package com.ssp.ding.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.*;
import com.ssp.ding.api.DingDepartmentService;
import com.ssp.ding.api.DingUserService;
import com.ssp.ding.service.DingClient;
import com.ssp.ding.service.DingTalkClientFactory;
import com.ssp.ding.service.impl.DefaultDingService;
import lombok.Builder;
import org.springframework.core.convert.ConversionService;

/**
 * 通讯录api构建
 *
 * @author: sunshaoping
 * @date: Create by in 11:23 上午 2020/6/19
 */
@Builder
public class ContactsConfig {

    private final ObjectMapper objectMapper;

    private final DingClient dingClient;

    private final ConversionService conversionService;


    public DingService dingService(DingConfigStorage dingConfigStorage, DingTalkClientFactory dingTalkClientFactory) {
        return new DefaultDingService(dingConfigStorage, dingTalkClientFactory);
    }

    public DingDepartmentService dingDepartmentService() {
        return new DefaultDingDepartmentService(dingClient, conversionService, objectMapper);
    }

    public DingUserService dingUserService() {
        return new DefaultDingUserService(dingClient, conversionService);
    }

    public DefaultDingRoleService dingRoleService() {
        return new DefaultDingRoleService(dingClient, conversionService);
    }

}
