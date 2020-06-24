package com.ssp.ding.configuration;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.DefaultDingCallbackManageService;
import com.ssp.ding.DefaultDingCallbackService;
import com.ssp.ding.api.DingCallbackManageService;
import com.ssp.ding.api.DingCallbackService;
import com.ssp.ding.handler.CallbackEvent;
import com.ssp.ding.handler.DingCallbackHandler;
import com.ssp.ding.properties.DingCallbackProperties;
import com.ssp.ding.properties.DingProperties;
import com.ssp.ding.service.DingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.Objects;

import static com.ssp.ding.properties.DingCallbackProperties.PREFIX;

/**
 * 钉钉回调配置
 *
 * @author: sunshaoping
 * @date: Create by in 10:51 上午 2020/6/23
 */

@Configuration
@Import(DingConfiguration.class)
@ConditionalOnClass(DingCallbackManageService.class)
@EnableConfigurationProperties(DingCallbackProperties.class)
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class CallbackConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private final DingClient dingClient;

    private final ConversionService conversionService;

    private final ObjectMapper objectMapper;

    private final DingCallbackProperties dingCallbackProperties;

    private List<DingCallbackHandler<? extends CallbackEvent>> dingCallbackHandlers;

    @Bean
    @ConditionalOnMissingBean
    public DingCallbackManageService dingCallbackManageService() {
        return new DefaultDingCallbackManageService(dingClient, conversionService, dingCallbackProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingCallbackService dingCallbackService() {
        return new DefaultDingCallbackService(dingCallbackProperties, objectMapper);
    }

    @Autowired(required = false)
    public void setDingCallbackHandlers(List<DingCallbackHandler<?>> dingCallbackHandlers) {
        this.dingCallbackHandlers = dingCallbackHandlers;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (CollUtil.isEmpty(dingCallbackHandlers)) {
            return;
        }
        DingCallbackService dingCallbackService = event.getApplicationContext().getBean(DingCallbackService.class);
        if (Objects.isNull(dingCallbackService)) {
            return;
        }
        dingCallbackHandlers.forEach(dingCallbackService::registerCallBackHandler);
    }
}
