package com.ssp.ding.configuration;

import com.ssp.ding.DingDepartmentService;
import com.ssp.ding.DingUserService;
import com.ssp.ding.DefaultDingDepartmentService;
import com.ssp.ding.DefaultDingUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.convert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.ConverterRegistry;


/**
 * 通讯录配置
 *
 * @author: sunshaoping
 * @date: Create by in 3:47 下午 2020/6/8
 */
@Configuration
public class ContactsConfiguration implements ConverterConfigurer {

    private final ObjectMapper objectMapper;

    @Autowired
    public ContactsConfiguration(@Qualifier(ConverterConfiguration.DING_OBJECT_MAPPER) ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    @ConditionalOnMissingBean
    public DingDepartmentService dingDepartmentService() {
        return new DefaultDingDepartmentService(objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingUserService dingUserService() {

        return new DefaultDingUserService();
    }

    @Override
    public void converter(ConverterRegistry converterRegistry) {
        converterRegistry.addConverter(new DingUserResponseConverter(objectMapper));
        converterRegistry.addConverter(new DingUserSimpleResponseConverter());
        converterRegistry.addConverter(new OapiUserCreateRequestConverter(objectMapper));
        converterRegistry.addConverter(new OapiUserUpdateRequestConverter(objectMapper));
        converterRegistry.addConverter(new AdminResponseConverter());
        converterRegistry.addConverter(new OapiDepartmentCreateRequestConverter());
        converterRegistry.addConverter(new DingDepartmentResponseConverter());
    }
}
