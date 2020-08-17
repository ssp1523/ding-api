package com.ssp.ding.service.impl;

import com.ssp.ding.DingApi;
import com.ssp.ding.service.DingLogger;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import lombok.extern.slf4j.Slf4j;

import static com.ssp.ding.DingService.Api.GET_TOKEN;

/**
 * 钉钉日志默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 1:51 下午 2020/8/13
 */
@Slf4j
public class DefaultDingLogger implements DingLogger {

    @Override
    public void request(DingApi dingApi, TaobaoRequest<?> request) {
        if (GET_TOKEN == dingApi) {
            //token 请求信息不打印
            if (log.isDebugEnabled()) {
                log.debug("request [{}]", dingApi.getSketch());
            }
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug("request [{}],{}", dingApi.getSketch(), request.getTextParams());
        }
    }

    @Override
    public void response(DingApi dingApi, TaobaoResponse response) {

        if (response.isSuccess()) {
            //成功日志
            if (log.isDebugEnabled()) {
                log.debug("response [{}],{}", dingApi.getSketch(), response.getBody());
            }
        } else {
            //失败日志
            log.error("response [{}],错误码:{},错误原因:{}", dingApi.getSketch(),
                    response.getErrorCode(), response.getMsg());
        }

    }

    @Override
    public void exception(DingApi dingApi, ApiException e) {
        log.error("exception [{}],错误码:{},错误原因:{}", dingApi.getSketch(), e.getErrCode(), e.getErrMsg());
    }
}
