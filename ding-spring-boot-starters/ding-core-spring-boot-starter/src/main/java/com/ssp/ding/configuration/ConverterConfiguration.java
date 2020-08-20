package com.ssp.ding.configuration;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.convert.ConverterConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Map;
import java.util.Objects;

/**
 * 转换器配置类
 *
 * @author: sunshaoping
 * @date: Create by in 10:34 上午 2020/6/9
 */
@Slf4j
@Configuration
public class ConverterConfiguration implements ApplicationListener<ContextRefreshedEvent>, DingConf {


    @Bean(name = DING_CONVERSION_SERVICE)
    @ConditionalOnMissingBean(name = DING_CONVERSION_SERVICE)
    public ConfigurableConversionService dingConversionService() {
        return new DefaultConversionService();
    }


    /**
     * json ObjectMapper
     */
    @Bean(name = DING_OBJECT_MAPPER)
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
        ApplicationContext applicationContext = event.getApplicationContext();
        Map<String, ConverterConfigurer> converterConfigurers = applicationContext.getBeansOfType(ConverterConfigurer.class);
        if (CollUtil.isEmpty(converterConfigurers)) {
            return;
        }
        ConfigurableConversionService dingConversionService =
                applicationContext.getBean(DING_CONVERSION_SERVICE, ConfigurableConversionService.class);
        if (Objects.isNull(dingConversionService)) {
            log.error("没找到转换器bean,beanName=" + DING_CONVERSION_SERVICE);
            return;
        }
        converterConfigurers.values().forEach(converterConfigurer ->
                converterConfigurer.converter(dingConversionService)
        );
    }

}
