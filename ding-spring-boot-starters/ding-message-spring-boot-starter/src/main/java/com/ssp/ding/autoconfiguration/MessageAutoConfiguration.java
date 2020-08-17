package com.ssp.ding.autoconfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.*;
import com.ssp.ding.configuration.DingConfiguration;
import com.ssp.ding.convert.ConverterConfigurer;
import com.ssp.ding.convert.OapiChatCreateRequestConverter;
import com.ssp.ding.convert.OapiChatUpdateRequestConverter;
import com.ssp.ding.properties.DingProperties;
import com.ssp.ding.service.DingClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;

import static com.ssp.ding.configuration.ConverterConfiguration.DING_CONVERSION_SERVICE;

/**
 * 消息自动装配
 *
 * @author: sunshaoping
 * @date: Create by in 3:02 下午 2020/6/30
 */

@ConditionalOnClass(DingMessageService.class)
@Import({DingConfiguration.class})
@ConditionalOnProperty(prefix = DingProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class MessageAutoConfiguration implements ConverterConfigurer {

    private final DingClient dingClient;

    private final ConversionService conversionService;

    private final ObjectMapper objectMapper;

    public MessageAutoConfiguration(DingClient dingClient, @Qualifier(DING_CONVERSION_SERVICE) ConversionService conversionService, ObjectMapper objectMapper) {
        this.dingClient = dingClient;
        this.conversionService = conversionService;
        this.objectMapper = objectMapper;
    }

    @Bean
    @ConditionalOnMissingBean
    public DingChatService dingChatService() {
        return new DefaultDingChatService(dingClient, conversionService);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingCorpConversationService dingCorpConversationService(DingMediaService dingMediaService) {
        return new DefaultDingCorpConversationService(dingClient, conversionService, objectMapper, dingMediaService);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingMediaMessageService dingMediaMessageService() {
        DingMediaService dingMediaService = dingMediaService();
        return new DefaultDingMediaMessageService(dingMediaService, dingMessageService(dingMediaService));
    }

    public DingMediaService dingMediaService() {
        return new DefaultDingMediaService(dingClient);
    }

    public DingMessageService dingMessageService(DingMediaService dingMediaService) {
        return new DefaultDingMessageService(dingClient, conversionService, objectMapper, dingMediaService);
    }

    @Override
    public void converter(ConverterRegistry converterRegistry) {
        converterRegistry.addConverter(new OapiChatCreateRequestConverter());
        converterRegistry.addConverter(new OapiChatUpdateRequestConverter());
    }
}
