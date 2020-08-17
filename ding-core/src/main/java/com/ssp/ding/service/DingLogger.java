package com.ssp.ding.service;

import com.ssp.ding.DingApi;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

/**
 * 钉钉日志
 *
 * @author: sunshaoping
 * @date: Create by in 1:45 下午 2020/8/13
 */
public interface DingLogger {


    /**
     * 请求日志
     *
     * @param dingApi 请求接口
     * @param request       请求数据
     */
    void request(DingApi dingApi, TaobaoRequest<?> request);

    /**
     * 响应日志
     *
     * @param dingApi 请求接口
     * @param response      响应数据
     */
    void response(DingApi dingApi, TaobaoResponse response);

    /**
     * 异常日志
     *
     * @param dingApi 请求接口
     * @param e             异常
     */
    void exception(DingApi dingApi, ApiException e);
}
