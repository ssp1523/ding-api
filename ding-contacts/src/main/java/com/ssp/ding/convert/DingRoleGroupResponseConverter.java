package com.ssp.ding.convert;

import cn.hutool.core.collection.CollUtil;
import com.dingtalk.api.response.OapiRoleListResponse;
import com.ssp.ding.response.DingRoleGroupResponse;
import com.ssp.ding.response.DingRoleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
public class DingRoleGroupResponseConverter implements Converter<OapiRoleListResponse.OpenRoleGroup, DingRoleGroupResponse> {

    @Override
    public DingRoleGroupResponse convert(OapiRoleListResponse.OpenRoleGroup roleGroup) {

        List<OapiRoleListResponse.OpenRole> openRoles = roleGroup.getRoles();
        List<DingRoleResponse> roles = null;
        if (CollUtil.isNotEmpty(openRoles)) {
            roles = openRoles.stream()
                    .map(openRole -> DingRoleResponse.builder()
                            .name(openRole.getName())
                            .roleId(openRole.getId())
                            .groupId(roleGroup.getGroupId())
                            .build())
                    .collect(Collectors.toList());
        }
        return DingRoleGroupResponse.builder()
                .name(roleGroup.getName())
                .groupId(roleGroup.getGroupId())
                .roles(roles)
                .build();
    }
}
