package com.ssp.ding.service.impl;

import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGetJsapiTicketRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.ssp.ding.DingConfigStorage;
import com.ssp.ding.DingService;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.response.DingSnsUserInfoResponse;
import com.ssp.ding.response.DingUserInfoResponse;
import com.ssp.ding.service.DingClient;
import com.ssp.ding.service.DingTalkClientFactory;
import com.ssp.ding.exception.DingException;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

/**
 * 钉钉服务默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 2:11 下午 2020/6/8
 */
@Slf4j
@RequiredArgsConstructor
public class DefaultDingService implements DingService, DingConf, DingClient {

    private final DingConfigStorage dingConfigStorage;

    private final DingTalkClientFactory dingTalkClientFactory;

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
                log.info("开始获取钉钉token");
                OapiGettokenResponse response = dingTalkClientFactory.getClient(GET_TOKEN)
                        .execute(request);
                dingConfigStorage.updateAccessToken(response.getAccessToken(), Duration.ofSeconds(response.getExpiresIn()));
                log.info("获取钉钉token成功");
                return response.getAccessToken();
            } catch (ApiException e) {
                log.error("获取钉钉token失败:{},错误码:{},错误原因:{},错误子码:{},错误子码原因:{}",
                        e.getMessage(), e.getErrCode(), e.getErrMsg(), e.getSubErrCode(), e.getSubErrMsg());
                throw new DingException(e.getErrCode(), e.getErrMsg(), e.getMessage(), e);
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
        //TODO
        return null;
    }

    @Override
    public DingSnsUserInfoResponse getUserInfoByCode(String tmpAuthCode) {
        //TODO
        return null;
    }

    public <T extends TaobaoResponse> T execute(String path, TaobaoRequest<T> request) throws DingException {
        DingTalkClient client = dingTalkClientFactory.getClient(path);

        try {
            log.info("钉钉请求信息,{},{},{}", request.getTopHttpMethod(), path, request.getTextParams());
            T response = client.execute(request, getAccessToken());
            log.info("钉钉响应信息:{}", response.getBody());
            if (response.isSuccess()) {
                return response;
            }
            log.error("钉钉接口失败,错误码:{},错误原因:{},错误子码:{},错误子码原因:{}",
                    response.getErrorCode(), response.getMsg(), response.getSubCode(), response.getSubMsg());
            throw new DingException(response.getErrorCode(), response.getMsg());
        } catch (ApiException e) {
            log.error("钉钉接口失败:{},错误码:{},错误原因:{},错误子码:{},错误子码原因:{}",
                    e.getMessage(), e.getErrCode(), e.getErrMsg(), e.getSubErrCode(), e.getSubErrMsg());
            throw new DingException(e.getErrCode(), e.getErrMsg(), e.getMessage(), e);

        }
    }
}
