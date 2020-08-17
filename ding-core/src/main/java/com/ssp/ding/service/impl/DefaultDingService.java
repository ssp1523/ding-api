package com.ssp.ding.service.impl;

import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGetJsapiTicketRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.ssp.ding.DingConfigStorage;
import com.ssp.ding.DingApi;
import com.ssp.ding.DingService;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.response.DingSnsUserInfoResponse;
import com.ssp.ding.response.DingUserInfoResponse;
import com.ssp.ding.service.DingClient;
import com.ssp.ding.service.DingLogger;
import com.ssp.ding.service.DingTalkClientFactory;
import com.ssp.ding.utils.DingExceptionUtils;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

import static com.ssp.ding.DingService.Api.*;

/**
 * 钉钉服务默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 2:11 下午 2020/6/8
 */
@RequiredArgsConstructor
public class DefaultDingService implements DingService, DingClient {

    private final DingConfigStorage dingConfigStorage;

    private final DingTalkClientFactory dingTalkClientFactory;

    private final DingLogger logger;

    @Override
    public String getAccessToken() {
        String accessToken = dingConfigStorage.getAccessToken();
        if (StrUtil.isBlank(accessToken)) {
            accessToken = refreshAccessToken();
        }
        return accessToken;
    }

    @Override
    public String refreshAccessToken() {
        return dingConfigStorage.accessTokenLock(() -> {
            dingConfigStorage.expireAccessToken();
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(dingConfigStorage.getAppKey());
            request.setAppsecret(dingConfigStorage.getAppSecret());
            try {
                logger.request(GET_TOKEN, request);
                OapiGettokenResponse response = dingTalkClientFactory.getClient(GET_TOKEN)
                        .execute(request);
                logger.response(GET_TOKEN, response);
                if (response.isSuccess()) {
                    dingConfigStorage.updateAccessToken(response.getAccessToken(), Duration.ofSeconds(response.getExpiresIn()));
                    return response.getAccessToken();
                }
                throw DingExceptionUtils.of(response);
            } catch (ApiException e) {
                logger.exception(GET_TOKEN, e);
                throw DingExceptionUtils.of(e);
            }
        });

    }

    @Override
    public String getJsApiTicket() {
        String jsApiTicket = dingConfigStorage.getJsApiTicket();
        if (StrUtil.isBlank(jsApiTicket)) {
            jsApiTicket = refreshJsApiTicket();
        }
        return jsApiTicket;
    }

    @Override
    public String refreshJsApiTicket() {
        return dingConfigStorage.jsApiTicketLock(() -> {
            OapiGetJsapiTicketRequest req = new OapiGetJsapiTicketRequest();
            OapiGetJsapiTicketResponse response = execute(JS_API_TICKET, req);
            String ticket = response.getTicket();
            dingConfigStorage.updateJsApiTicket(ticket, Duration.ofSeconds(response.getExpiresIn()));
            return ticket;
        });
    }

    @Override
    public DingConfigStorage getDingConfigStorage() {
        return dingConfigStorage;
    }

    @Override
    public DingUserInfoResponse getUserInfo(String code) {

        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(code);
        OapiUserGetuserinfoResponse response = execute(GET_USER_INFO, request);
        String userId = response.getUserid();

        return DingUserInfoResponse.builder()
                .userId(userId)
                .isSys(response.getIsSys())
                .sysLevel(response.getSysLevel())
                .build();
    }

    @Override
    public DingSnsUserInfoResponse getUserInfoByCode(String tmpAuthCode, String appId, String appSecret) {
        try {
            OapiSnsGetuserinfoBycodeRequest request = new OapiSnsGetuserinfoBycodeRequest();
            request.setTmpAuthCode(tmpAuthCode);
            logger.request(GET_USER_INFO, request);
            OapiSnsGetuserinfoBycodeResponse response = dingTalkClientFactory.getClient(GET_USER_INFO).execute(request, appId, appSecret);
            logger.response(GET_USER_INFO, response);
            if (response.isSuccess()) {
                OapiSnsGetuserinfoBycodeResponse.UserInfo userInfo = response.getUserInfo();
                return DingSnsUserInfoResponse.builder()
                        .nick(userInfo.getNick())
                        .openId(userInfo.getOpenid())
                        .unionId(userInfo.getUnionid())
                        .build();
            }
            throw DingExceptionUtils.of(response);
        } catch (ApiException e) {
            throw DingExceptionUtils.of(e);
        }

    }

    public <T extends TaobaoResponse> T execute(DingApi dingApi, TaobaoRequest<T> request) throws DingException {
        DingTalkClient client = dingTalkClientFactory.getClient(dingApi);

        try {
            logger.request(dingApi, request);
            T response = client.execute(request, getAccessToken());
            logger.response(dingApi, response);
            if (response.isSuccess()) {
                return response;
            }
            throw DingExceptionUtils.of(response);
        } catch (ApiException e) {
            logger.exception(dingApi, e);
            throw DingExceptionUtils.of(e);

        }
    }
}
