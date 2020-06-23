package com.ssp.ding.convert;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;
import java.util.Objects;

import static com.ssp.ding.conf.TypeReferenceConf.LIST_LONG;
import static com.ssp.ding.conf.TypeReferenceConf.LIST_STRING;

/**
 * OapiDepartmentGetResponse -> DingDepartmentDetailResponse
 *
 * @author: sunshaoping
 * @date: Create by in 3:29 下午 2020/6/9
 */
@Slf4j
public class DingDepartmentDetailResponseConvert implements Converter<OapiDepartmentGetResponse, DingDepartmentDetailResponse> {

    private final ObjectMapper objectMapper;

    public DingDepartmentDetailResponseConvert(ObjectMapper objectMapper) {this.objectMapper = objectMapper;}


    @Override
    public DingDepartmentDetailResponse convert(OapiDepartmentGetResponse source) {

        DingDepartmentDetailResponse detailResponse = new DingDepartmentDetailResponse();

        detailResponse.setId(source.getId());
        detailResponse.setName(source.getName());
        if (Objects.nonNull(source.getOrder())) {
            detailResponse.setOrder(Math.toIntExact(source.getOrder()));
        }
        detailResponse.setParentId(source.getParentid());
        detailResponse.setCreateDeptGroup(source.getCreateDeptGroup());
        detailResponse.setAutoAddUser(source.getAutoAddUser());
        detailResponse.setDeptHiding(source.getDeptHiding());

        if (StrUtil.isNotBlank(source.getDeptPermits())) {
            try {
                detailResponse.setDeptPermits(objectMapper.readValue(source.getDeptPermits(), LIST_LONG));
            } catch (IOException e) {
                log.error("deptPermits 反序列化错误:{}", e.getMessage(), e);
            }
        }
        if (StrUtil.isNotBlank(source.getUserPermits())) {
            try {
                detailResponse.setUserPermits(objectMapper.readValue(source.getUserPermits(), LIST_STRING));
            } catch (IOException e) {
                log.error("userPermits 反序列化错误:{}", e.getMessage(), e);
            }
        }
        if (StrUtil.isNotBlank(source.getOuterPermitDepts())) {

            try {
                detailResponse.setOuterPermitDepts(objectMapper.readValue(source.getOuterPermitDepts(), LIST_LONG));
            } catch (IOException e) {
                log.error("outerPermitDepts 反序列化错误:{}", e.getMessage(), e);
            }
        }
        if (StrUtil.isNotBlank(source.getOuterPermitUsers())) {
            try {
                detailResponse.setOuterPermitUsers(objectMapper.readValue(source.getOuterPermitUsers(), LIST_STRING));
            } catch (IOException e) {
                log.error("outerPermitUsers 反序列化错误:{}", e.getMessage(), e);
            }

        }
        if (StrUtil.isNotBlank(source.getDeptManagerUseridList())) {

            try {
                detailResponse.setDeptManagerUserIdList(objectMapper.readValue(source.getDeptManagerUseridList(), LIST_STRING));
            } catch (IOException e) {
                log.error("deptManagerUserIdList 反序列化错误:{}", e.getMessage(), e);
            }

        }


        detailResponse.setOuterDept(source.getOuterDept());
        detailResponse.setOrgDeptOwner(source.getOrgDeptOwner());
        detailResponse.setSourceIdentifier(source.getSourceIdentifier());
        detailResponse.setGroupContainSubDept(source.getGroupContainSubDept());


        return detailResponse;
    }
}
