package com.ssp.ding.configuration;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.convert.ConverterConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.List;
import java.util.Objects;

/**
 * 转换器配置类
 *
 * @author: sunshaoping
 * @date: Create by in 10:34 上午 2020/6/9
 */
@Configuration
public class ConverterConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    public static final String DING_CONVERSION_SERVICE = "dingConversionService";

    private List<ConverterConfigurer> converterConfigurers;

    @Bean
    @ConditionalOnMissingBean(name = DING_CONVERSION_SERVICE)
    public ConfigurableConversionService dingConversionService() {
        return new DefaultConversionService();
    }


    /**
     * json ObjectMapper
     */
    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //无引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        return objectMapper;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (CollUtil.isEmpty(converterConfigurers)) {
            return;
        }
        ConfigurableConversionService dingConversionService =
                event.getApplicationContext().getBean(DING_CONVERSION_SERVICE, ConfigurableConversionService.class);
        if (Objects.isNull(dingConversionService)) {
            return;
        }
        converterConfigurers.forEach(converterConfigurer ->
                converterConfigurer.converter(dingConversionService));
    }

    @Autowired(required = false)
    public void setConverterConfigurers(List<ConverterConfigurer> converterConfigurers) {
        this.converterConfigurers = converterConfigurers;
    }
}
