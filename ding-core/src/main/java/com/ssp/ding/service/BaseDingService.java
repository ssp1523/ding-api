package com.ssp.ding.service;

import cn.hutool.core.lang.Assert;
import com.ssp.ding.exception.DingException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;

/**
 * 钉钉Service基类
 *
 * @author: sunshaoping
 * @date: Create by in 4:40 下午 2020/6/7
 */
@Slf4j
public abstract class BaseDingService {

    protected final DingClient dingClient;

    protected final ConversionService conversionService;

    protected BaseDingService(DingClient dingClient, ConversionService conversionService) {
        this.dingClient = dingClient;
        this.conversionService = conversionService;
    }


    public <T> T convert(Object source, Class<T> targetType) {
        Assert.notNull(source, "source 必输");
        boolean canConvert = conversionService.canConvert(source.getClass(), targetType);
        Assert.isTrue(canConvert, "目标类型:{},未找到转换器", targetType);
        return conversionService.convert(source, targetType);
    }

    public <T extends TaobaoResponse> T execute(String path, TaobaoRequest<T> request) throws DingException {
        return dingClient.execute(path, request);
    }

    public <T> T execute(String path, TaobaoRequest<?> request, Class<T> responseType) throws DingException {
        TaobaoResponse response = dingClient.execute(path, request);
        return convert(response, responseType);
    }

}
