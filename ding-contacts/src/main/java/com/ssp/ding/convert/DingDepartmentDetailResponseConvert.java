package com.ssp.ding.convert;

import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * OapiDepartmentGetResponse -> DingDepartmentDetailResponse
 *
 * @author: sunshaoping
 * @date: Create by in 3:29 下午 2020/6/9
 */
public class DingDepartmentDetailResponseConvert implements Converter<OapiDepartmentGetResponse, DingDepartmentDetailResponse> {


    @Override
    public DingDepartmentDetailResponse convert(OapiDepartmentGetResponse source) {
//        source1.setAutoAddUser();
//
//        source1.setCreateDeptGroup();
//        source1.setDeptHiding();
//        source1.setDeptManagerUseridList();
//        source1.setDeptPerimits();
//        source1.setDeptPermits();
//        source1.setGroupContainSubDept();
//        source1.setId();
//        source1.setIsFromUnionOrg();
//        source1.setName();
//        source1.setOrder();
//        source1.setOrgDeptOwner();
//        source1.setOuterDept();
//        source1.setOuterPermitDepts();
//        source1.setOuterPermitUsers();
//        source1.setParentid();
//        source1.setSourceIdentifier();
//        source1.setUserPermits();

        return DingDepartmentDetailResponse.builder()

                .build();
    }
}
