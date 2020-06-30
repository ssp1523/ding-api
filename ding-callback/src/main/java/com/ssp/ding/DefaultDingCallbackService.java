package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptException;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.dingtalk.oapi.lib.aes.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.handler.CallbackEvent;
import com.ssp.ding.handler.DingCallbackHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;

/**
 * 钉钉回调
 *
 * @author: sunshaoping
 * @date: Create by in 4:41 下午 2020/6/23
 */
@Slf4j
public class DefaultDingCallbackService implements DingCallbackService {

    /**
     * 相应钉钉回调时的值
     */
    private static final String CALLBACK_RESPONSE_SUCCESS = "success";


    private final DingTalkEncryptor dingTalkEncryptor;

    private final ObjectMapper objectMapper;


    private final List<DingCallbackHandler<? extends CallbackEvent>> callbackHandlerCache = new ArrayList<>();


    public DefaultDingCallbackService(DingCallbackConfigStorage configStorage, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        try {
            this.dingTalkEncryptor = new DingTalkEncryptor(configStorage.getToken(), configStorage.getAesKey(), configStorage.getCorpId());
        } catch (DingTalkEncryptException e) {
            throw new DingException(e.getMessage(), e);
        }
        callbackHandlerCache.add(new DefaultDingCallbackHandler());
    }


    @Override
    public synchronized void registerCallBackHandler(DingCallbackHandler<? extends CallbackEvent> handler) {
        Assert.notNull(handler, "handler 必输");
        callbackHandlerCache.add(handler);
    }

    @Override
    public Map<String, String> decryptAndParseCallback(String signature, String timestamp, String nonce, String encryptJson) {
        String plainText = decrypt(signature, timestamp, nonce, encryptJson);
        return callback(plainText);
    }

    @Override
    public String decrypt(String signature, String timestamp, String nonce, String encryptJson) {
        log.info("钉钉回调数据,signature:{}, timestamp:{},nonce:{},json:{}", signature, timestamp, nonce, encryptJson);
        try {

            JsonNode jsonNode = objectMapper.readTree(encryptJson);

            JsonNode encrypt = jsonNode.findValue("encrypt");
            //从post请求的body中获取回调信息的加密数据进行解密处理
            String encryptMsg = encrypt.asText();

            return dingTalkEncryptor.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
        } catch (IOException e) {
            throw new DingException(e.getMessage(), e);
        } catch (DingTalkEncryptException e) {
            throw new DingException(String.valueOf(e.getCode()), e.getMessage(), e);
        }
    }

    @Override
    public Map<String, String> callback(String plainText) {
        try {
            JsonNode result = objectMapper.readTree(plainText);

            //根据回调数据类型做不同的业务处理
            String eventType = result.findValue("EventType").asText();

            doCallBackHandler(eventType, plainText, result);
            // 返回success的加密信息表示回调处理成功

            return dingTalkEncryptor.getEncryptedMap(CALLBACK_RESPONSE_SUCCESS, System.currentTimeMillis(), Utils.getRandomStr(8));
        } catch (Exception e) {
            //失败的情况，应用的开发者应该通过告警感知，并干预修复
            log.error("回到失败,json:{}", plainText, e);
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
