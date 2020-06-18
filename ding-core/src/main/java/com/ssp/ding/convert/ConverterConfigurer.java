package com.ssp.ding.convert;

import org.springframework.core.convert.converter.ConverterRegistry;

/**
 * 转换器配置类
 *
 * @author: sunshaoping
 * @date: Create by in 10:25 上午 2020/6/9
 */
public interface ConverterConfigurer {

    /**
     * 注册转换器
     *
     * @param converterRegistry 转换器注册类
     */
    void converter(ConverterRegistry converterRegistry);
}
