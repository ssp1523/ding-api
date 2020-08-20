package com.ssp.ding.convert;

import cn.hutool.core.collection.CollUtil;
import com.dingtalk.api.response.OapiRoleSimplelistResponse;
import com.google.common.collect.Lists;
import com.ssp.ding.response.ManageScopeResponse;
import com.ssp.ding.response.RoleUserSimpleResponse;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

/**
 * 角色下的员工列表转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:11 上午 2020/8/17
 */
public class RoleUserSimpleResponseConverter implements Converter<OapiRoleSimplelistResponse.OpenEmpSimple, RoleUserSimpleResponse> {

    @Override
    public RoleUserSimpleResponse convert(OapiRoleSimplelistResponse.OpenEmpSimple source) {
        List<OapiRoleSimplelistResponse.OrgDeptVo> orgDeptVos = source.getManageScopes();
        List<ManageScopeResponse> manageScopes = null;
        if (CollUtil.isNotEmpty(orgDeptVos)) {
            manageScopes = Lists.newArrayListWithExpectedSize(orgDeptVos.size());
            orgDeptVos.stream()
                    .map(this::createManageScopeResponse)
                    .forEach(manageScopes::add);
        }


        return RoleUserSimpleResponse.builder()
                .name(source.getName())
                .userId(source.getUserid())
                .manageScopes(manageScopes)
                .build();
    }

    private ManageScopeResponse createManageScopeResponse(OapiRoleSimplelistResponse.OrgDeptVo orgDeptVo) {
        return ManageScopeResponse.builder()
                .deptId(orgDeptVo.getDeptId())
                .name(orgDeptVo.getName())
                .build();

    }
}
