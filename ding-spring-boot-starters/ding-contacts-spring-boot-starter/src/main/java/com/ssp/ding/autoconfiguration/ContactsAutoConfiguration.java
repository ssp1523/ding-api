package com.ssp.ding.autoconfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.DefaultDingDepartmentService;
import com.ssp.ding.DefaultDingRoleService;
import com.ssp.ding.DefaultDingUserService;
import com.ssp.ding.DingDepartmentService;
import com.ssp.ding.DingUserService;
import com.ssp.ding.configuration.CallbackConfiguration;
import com.ssp.ding.configuration.DingConfiguration;
import com.ssp.ding.convert.*;
import com.ssp.ding.handler.SpringEventCorpCallbackHandler;
import com.ssp.ding.handler.SpringEventDeptCallbackHandler;
import com.ssp.ding.handler.SpringEventRoleCallbackHandler;
import com.ssp.ding.handler.SpringEventUserCallbackHandler;
import com.ssp.ding.properties.DingProperties;
import com.ssp.ding.service.DingClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;

import static com.ssp.ding.configuration.ConverterConfiguration.DING_CONVERSION_SERVICE;
import static com.ssp.ding.configuration.ConverterConfiguration.DING_OBJECT_MAPPER;
import static com.ssp.ding.properties.DingCallbackProperties.PREFIX;


/**
 * 钉钉通讯录自动装配
 *
 * @author: sunshaoping
 * @date: Create by in 3:47 下午 2020/6/8
 */
@ConditionalOnClass(DingDepartmentService.class)
@Import({DingConfiguration.class, CallbackConfiguration.class, ContactsAutoConfiguration.CallbackConfig.class})
@ConditionalOnProperty(prefix = DingProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class ContactsAutoConfiguration implements ConverterConfigurer {

    private final ObjectMapper objectMapper;

    private final DingClient dingClient;

    private final ConversionService conversionService;

    public ContactsAutoConfiguration(@Lazy @Qualifier(DING_OBJECT_MAPPER) ObjectMapper objectMapper, DingClient dingClient,
                                     @Qualifier(DING_CONVERSION_SERVICE) ConversionService conversionService) {
        this.objectMapper = objectMapper;
        this.dingClient = dingClient;
        this.conversionService = conversionService;
    }

    @Bean
    @ConditionalOnMissingBean
    public DingDepartmentService dingDepartmentService() {
        return new DefaultDingDepartmentService(dingClient, conversionService, objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingUserService dingUserService() {
        return new DefaultDingUserService(dingClient, conversionService);
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultDingRoleService dingRoleService() {
        return new DefaultDingRoleService(dingClient, conversionService);
    }

    @Override
    public void converter(ConverterRegistry converterRegistry) {
        converterRegistry.addConverter(new DingUserResponseConverter(objectMapper));
        converterRegistry.addConverter(new DingUserSimpleResponseConverter());
        converterRegistry.addConverter(new OapiUserCreateRequestConverter(objectMapper));
        converterRegistry.addConverter(new OapiUserUpdateRequestConverter(objectMapper));
        converterRegistry.addConverter(new AdminResponseConverter());
        converterRegistry.addConverter(new DingRoleResponseConverter());
        converterRegistry.addConverter(new DingRoleGroupResponseConverter());
        converterRegistry.addConverter(new OapiDepartmentCreateRequestConverter());
        converterRegistry.addConverter(new DingDepartmentResponseConverter());
        converterRegistry.addConverter(new DingUserListResponseConverter(objectMapper));
    }

    @Configuration
    @ConditionalOnProperty(prefix = PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
    public static class CallbackConfig {
        @Bean
        @ConditionalOnMissingBean(name = "springEventUserCallbackHandler")
        public SpringEventUserCallbackHandler springEventUserCallbackHandler() {
            return new SpringEventUserCallbackHandler();
        }

        @Bean
        @ConditionalOnMissingBean(name = "springEventCorpCallbackHandler")
        public SpringEventCorpCallbackHandler springEventCorpCallbackHandler() {
            return new SpringEventCorpCallbackHandler();
        }

        @Bean
        @ConditionalOnMissingBean(name = "springEventDeptCallbackHandler")
        public SpringEventDeptCallbackHandler springEventDeptCallbackHandler() {
            return new SpringEventDeptCallbackHandler();
        }

        @Bean
        @ConditionalOnMissingBean(name = "springEventRoleCallbackHandler")
        public SpringEventRoleCallbackHandler springEventRoleCallbackHandler() {
            return new SpringEventRoleCallbackHandler();
        }
    }

}
