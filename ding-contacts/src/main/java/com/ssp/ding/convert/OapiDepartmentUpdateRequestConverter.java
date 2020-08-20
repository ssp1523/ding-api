package com.ssp.ding.convert;

import cn.hutool.core.collection.CollUtil;
import com.dingtalk.api.request.OapiDepartmentUpdateRequest;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.request.DingDepartmentUpdateRequest;
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
public class OapiDepartmentUpdateRequestConverter implements Converter<DingDepartmentUpdateRequest, OapiDepartmentUpdateRequest> {

    @Override
    public OapiDepartmentUpdateRequest convert(DingDepartmentUpdateRequest request) {

        OapiDepartmentUpdateRequest updateRequest = new OapiDepartmentUpdateRequest();

        updateRequest.setAutoAddUser(request.getAutoAddUser());

        List<String> deptManagerUserIdList = request.getDeptManagerUserIdList();
        if (CollUtil.isNotEmpty(deptManagerUserIdList)) {
            updateRequest.setDeptManagerUseridList(String.join(DingConf.VERTICAL_BAR, deptManagerUserIdList));
        }

        updateRequest.setGroupContainHiddenDept(request.getGroupContainHiddenDept());
        updateRequest.setGroupContainOuterDept(request.getGroupContainOuterDept());
        updateRequest.setGroupContainSubDept(request.getGroupContainSubDept());
        updateRequest.setOrgDeptOwner(request.getOrgDeptOwner());

        updateRequest.setCreateDeptGroup(request.getCreateDeptGroup());

        updateRequest.setDeptHiding(request.getDeptHiding());

        List<Long> deptPermits = request.getDeptPermits();
        if (CollUtil.isNotEmpty(deptPermits)) {

            updateRequest.setDeptPermits(
                    deptPermits.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(DingConf.VERTICAL_BAR))
            );
        }

        updateRequest.setName(request.getName());
        updateRequest.setOrder(String.valueOf(request.getOrder()));
        updateRequest.setOuterDept(request.getOuterDept());
        updateRequest.setOuterDeptOnlySelf(request.getOuterDeptOnlySelf());
        List<Long> outerPermitDepts = request.getOuterPermitDepts();
        if (CollUtil.isNotEmpty(outerPermitDepts)) {

            updateRequest.setOuterPermitDepts(
                    outerPermitDepts.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(DingConf.VERTICAL_BAR))
            );
        }
        List<String> outerPermitUsers = request.getOuterPermitUsers();
        if (CollUtil.isNotEmpty(outerPermitUsers)) {
            updateRequest.setOuterPermitUsers(String.join(DingConf.VERTICAL_BAR, outerPermitUsers));
        }

        updateRequest.setParentid(String.valueOf(request.getParentId()));
        updateRequest.setSourceIdentifier(request.getSourceIdentifier());

        List<String> userPermits = request.getUserPermits();
        if (CollUtil.isNotEmpty(userPermits)) {
            updateRequest.setUserPermits(String.join(DingConf.VERTICAL_BAR, userPermits));
        }
        return updateRequest;

    }
}
