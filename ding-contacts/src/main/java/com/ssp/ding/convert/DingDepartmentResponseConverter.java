package com.ssp.ding.convert;

import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.ssp.ding.response.DingDepartmentResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * DingDepartmentResponse
 *
 * @author: sunshaoping
 * @date: Create by in 2:36 下午 2020/6/9
 */
public class DingDepartmentResponseConverter implements Converter<OapiDepartmentListResponse.Department, DingDepartmentResponse> {

    @Override
    public DingDepartmentResponse convert(OapiDepartmentListResponse.Department source) {

        return DingDepartmentResponse.builder()
                .autoAddUser(source.getAutoAddUser())
                .createDeptGroup(source.getCreateDeptGroup())
                .id(source.getId())
                .name(source.getName())
                .parentId(source.getParentid())
                .build();
    }
}
