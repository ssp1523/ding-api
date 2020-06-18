package com.ssp.ding.convert;

import cn.hutool.core.collection.CollUtil;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.request.DingDepartmentCreateRequest;
import com.dingtalk.api.request.OapiDepartmentCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OapiDepartmentCreateRequest 部门创建
 *
 * @author: sunshaoping
 * @date: Create by in 4:01 下午 2020/6/8
 */
@Slf4j
public class OapiDepartmentCreateRequestConverter implements Converter<DingDepartmentCreateRequest, OapiDepartmentCreateRequest> {

    @Override
    public OapiDepartmentCreateRequest convert(DingDepartmentCreateRequest request) {
        OapiDepartmentCreateRequest createRequest = new OapiDepartmentCreateRequest();

        createRequest.setCreateDeptGroup(request.getCreateDeptGroup());
        createRequest.setDeptHiding(request.getDeptHiding());

        List<Long> deptPermits = request.getDeptPermits();
        if (CollUtil.isNotEmpty(deptPermits)) {

            createRequest.setDeptPermits(
                    deptPermits.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(DingConf.VERTICAL_BAR))
            );
        }

        createRequest.setName(request.getName());
        createRequest.setOrder(request.getOrder());
        createRequest.setOuterDept(request.getOuterDept());
        createRequest.setOuterDeptOnlySelf(request.getOuterDeptOnlySelf());
        List<Long> outerPermitDepts = request.getOuterPermitDepts();
        if (CollUtil.isNotEmpty(outerPermitDepts)) {

            createRequest.setOuterPermitDepts(
                    outerPermitDepts.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(DingConf.VERTICAL_BAR))
            );
        }
        List<String> outerPermitUsers = request.getOuterPermitUsers();
        if (CollUtil.isNotEmpty(outerPermitUsers)) {
            createRequest.setOuterPermitUsers(String.join(DingConf.VERTICAL_BAR, outerPermitUsers));
        }

        createRequest.setParentid(String.valueOf(request.getParentId()));
        createRequest.setSourceIdentifier(request.getSourceIdentifier());

        List<String> userPermits = request.getUserPermits();
        if (CollUtil.isNotEmpty(userPermits)) {
            createRequest.setUserPermits(String.join(DingConf.VERTICAL_BAR, userPermits));
        }
        return createRequest;
    }
}
