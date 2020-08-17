package com.ssp.ding.convert;

import com.dingtalk.api.response.OapiRoleGetroleResponse;
import com.ssp.ding.response.DingRoleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
public class DingRoleResponseConverter implements Converter<OapiRoleGetroleResponse.OpenRole, DingRoleResponse> {

    @Override
    public DingRoleResponse convert(OapiRoleGetroleResponse.OpenRole role) {
        return DingRoleResponse.builder()
                .groupId(role.getGroupId())
                .name(role.getName())
                .build();
    }
}
