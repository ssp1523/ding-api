package com.ssp.ding.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.convert.ConverterConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器配置类
 *
 * @author: sunshaoping
 * @date: Create by in 10:34 上午 2020/6/9
 */
@Configuration
public class ConverterConfiguration {

    public static final String DING_CONVERT_SERVICE_BEAN = "dingConvertService";

    public static final String DING_OBJECT_MAPPER = "dingObjectMapper";

    private List<ConverterConfigurer> converterConfigurers = new ArrayList<>();

    @Bean(name = DING_CONVERT_SERVICE_BEAN)
    @ConditionalOnMissingBean(name = DING_CONVERT_SERVICE_BEAN)
    public ConversionService conversionService() {
        ConversionService conversionService = DefaultConversionService.getSharedInstance();
        if (conversionService instanceof ConverterRegistry) {
            ConverterRegistry converterRegistry = (ConverterRegistry) conversionService;
            converterConfigurers.forEach(converterConfigurer ->
                    converterConfigurer.converter(converterRegistry));
        }
        return conversionService;
    }

    @Autowired(required = false)
    public void setConverterConfigurers(List<ConverterConfigurer> converterConfigurers) {
        this.converterConfigurers = converterConfigurers;
    }

    @Bean(DING_OBJECT_MAPPER)
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //无引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        return objectMapper;

    }
}
