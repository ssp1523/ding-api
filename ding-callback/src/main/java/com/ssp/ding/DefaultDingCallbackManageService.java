package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.OapiCallBackGetCallBackFailedResultResponse;
import com.dingtalk.api.response.OapiCallBackGetCallBackResponse;
import com.ssp.ding.response.DingCallBackFailedResponse;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 钉钉回调管理默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 5:07 下午 2020/6/19
 */
@Slf4j
public class DefaultDingCallbackManageService extends BaseDingService implements DingCallbackManageService {


    private final DingCallbackConfigStorage configStorage;


    public DefaultDingCallbackManageService(DingClient dingClient, ConversionService conversionService, DingCallbackConfigStorage configStorage) {
        super(dingClient, conversionService);
        this.configStorage = configStorage;
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


}
