package com.ssp.ding.service;

import com.ssp.ding.DingApi;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import org.springframework.core.convert.ConversionService;

/**
 * 钉钉客户端
 *
 * @author: sunshaoping
 * @date: Create by in 7:05 下午 2020/6/10
 */
public interface DingClient extends ConversionService {

    <T extends TaobaoResponse> T execute(DingApi dingApi, TaobaoRequest<T> request);
}
