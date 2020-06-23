package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.OapiCallBackGetCallBackFailedResultResponse;
import com.dingtalk.api.response.OapiCallBackGetCallBackResponse;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptException;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.dingtalk.oapi.lib.aes.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.api.DingCallbackService;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.handler.CallbackEvent;
import com.ssp.ding.handler.DingCallbackHandler;
import com.ssp.ding.response.DingCallBackFailedResponse;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 钉钉回调管理默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 5:07 下午 2020/6/19
 */
@Slf4j
public class DefaultDingCallbackService extends BaseDingService implements DingCallbackService {
    /**
     * 相应钉钉回调时的值
     */
    private static final String CALLBACK_RESPONSE_SUCCESS = "success";


    private final DingTalkEncryptor dingTalkEncryptor;

    private final ObjectMapper objectMapper;

    private final DingCallbackConfigStorage configStorage;

    private final List<DingCallbackHandler<? extends CallbackEvent>> callbackHandlerCache = new ArrayList<>();

    public DefaultDingCallbackService(DingClient dingClient, ConversionService conversionService, DingCallbackConfigStorage configStorage, ObjectMapper objectMapper) {
        super(dingClient, conversionService);
        this.objectMapper = objectMapper;
        this.configStorage = configStorage;
        try {
            this.dingTalkEncryptor = new DingTalkEncryptor(configStorage.getToken(), configStorage.getAesKey(), configStorage.getCorpId());
        } catch (DingTalkEncryptException e) {
            throw new DingException(e.getMessage(), e);
        }
        callbackHandlerCache.add(new DefaultDingCallbackHandler());
    }


    @Override
    public void registerCallBack(DingCallback callback) {

        OapiCallBackRegisterCallBackRequest request = new OapiCallBackRegisterCallBackRequest();
        request.setUrl(callback.getUrl());
        request.setAesKey(callback.getAesKey());
        request.setToken(callback.getToken());
        request.setCallBackTag(callback.getCallBackTag());
        execute("/call_back/register_call_back", request);
    }

    @Override
    public void registerCallBack(List<String> callBackTag) {
        this.registerCallBack(
                DingCallback.builder()
                        .url(configStorage.getCallbackUrl())
                        .aesKey(configStorage.getAesKey())
                        .callBackTag(callBackTag)
                        .token(configStorage.getToken())
                        .build()

        );
    }

    @Override
    public DingCallback getCallBack() {
        OapiCallBackGetCallBackRequest request = new OapiCallBackGetCallBackRequest();
        OapiCallBackGetCallBackResponse response = execute("/call_back/get_call_back", request);

        return DingCallback.builder()
                .url(response.getUrl())
                .aesKey(response.getAesKey())
                .callBackTag(response.getCallBackTag())
                .token(response.getToken())
                .build();
    }

    @Override
    public void updateCallBack(DingCallback request) {

        OapiCallBackUpdateCallBackRequest callBackRequest = new OapiCallBackUpdateCallBackRequest();
        callBackRequest.setUrl(request.getUrl());
        callBackRequest.setAesKey(request.getAesKey());
        callBackRequest.setToken(request.getToken());
        callBackRequest.setCallBackTag(request.getCallBackTag());
        execute("/call_back/update_call_back", callBackRequest);

    }

    @Override
    public void updateCallBack(List<String> callBackTag) {
        this.updateCallBack(
                DingCallback.builder()
                        .url(configStorage.getCallbackUrl())
                        .aesKey(configStorage.getAesKey())
                        .callBackTag(callBackTag)
                        .token(configStorage.getToken())
                        .build()
        );
    }

    @Override
    public void deleteCallBack() {
        OapiCallBackDeleteCallBackRequest request = new OapiCallBackDeleteCallBackRequest();
        request.setHttpMethod("GET");
        execute("/call_back/delete_call_back", request);
    }

    @Override
    public DingPage<DingCallBackFailedResponse> getCallBackFailedResult() {
        OapiCallBackGetCallBackFailedResultRequest request = new OapiCallBackGetCallBackFailedResultRequest();
        OapiCallBackGetCallBackFailedResultResponse response = execute("/call_back/get_call_back_failed_result", request);
        List<OapiCallBackGetCallBackFailedResultResponse.Failed> failedList = response.getFailedList();
        if (CollUtil.isEmpty(failedList)) {
            return DingPage.empty();
        }
        List<DingCallBackFailedResponse> result = failedList.stream()
                .map(this::createDingCallBackFailedResponse)
                .collect(Collectors.toList());
        return new DingPage<>(response.getHasMore(), result);
    }

    private DingCallBackFailedResponse createDingCallBackFailedResponse(OapiCallBackGetCallBackFailedResultResponse.Failed failed) {
        return convert(failed, DingCallBackFailedResponse.class);
    }

    @Override
    public synchronized void registerCallBackHandler(DingCallbackHandler<? extends CallbackEvent> handler) {
        Assert.notNull(handler, "handler 必输");
        callbackHandlerCache.add(handler);
    }

    @Override
    public Map<String, String> callBackHandler(String signature, String timestamp, String nonce, String encryptJson) {
        try {
            log.info("钉钉回调数据,signature:{}, timestamp:{},nonce:{},json:{}", signature, timestamp, nonce, encryptJson);
            JsonNode jsonNode = objectMapper.readTree(encryptJson);
            JsonNode encrypt = jsonNode.findValue("encrypt");
            //从post请求的body中获取回调信息的加密数据进行解密处理
            String encryptMsg = encrypt.asText();

            String plainText = dingTalkEncryptor.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
            JsonNode result = objectMapper.readTree(plainText);

            //根据回调数据类型做不同的业务处理
            String eventType = result.findValue("EventType").asText();

            doCallBackHandler(eventType, plainText, result);
            // 返回success的加密信息表示回调处理成功
            return dingTalkEncryptor.getEncryptedMap(CALLBACK_RESPONSE_SUCCESS, System.currentTimeMillis(), Utils.getRandomStr(8));
        } catch (Exception e) {
            //失败的情况，应用的开发者应该通过告警感知，并干预修复
            log.error("回到失败,signature:{}, timestamp:{},nonce:{},json:{}", signature, timestamp, nonce, encryptJson, e);
            return Collections.emptyMap();
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends CallbackEvent> void doCallBackHandler(String eventType, String plainText, JsonNode result) {
        if (CollUtil.isEmpty(callbackHandlerCache)) {
            return;
        }

        for (DingCallbackHandler<? extends CallbackEvent> dingCallbackHandler : callbackHandlerCache) {
            DingCallbackHandler<T> handler = (DingCallbackHandler<T>) dingCallbackHandler;
            if (!handler.support(eventType)) {
                continue;
            }
            Class<T> parseJsonClass = handler.parseJsonClass();
            if (Objects.isNull(parseJsonClass)) {
                T event = null;
                try {
                    event = handler.parseJson(plainText);
                } catch (UnsupportedOperationException ignored) {
                }
                handler.callback(event);
                continue;
            }
            try {
                T event = objectMapper.treeToValue(result, parseJsonClass);
                handler.callback(event);
            } catch (JsonProcessingException e) {
                log.warn("json解析失败调用 parseJson 解析json,{},失败原因:{}", plainText, e.getMessage(), e);
                try {
                    T event = handler.parseJson(plainText);
                    handler.callback(event);
                } catch (UnsupportedOperationException exception) {
                    //不支持json字符串解析
                    throw new DingException("json解析失败," + plainText + ",失败原因:" + e.getMessage(), e);
                }
            }


        }

    }
}
