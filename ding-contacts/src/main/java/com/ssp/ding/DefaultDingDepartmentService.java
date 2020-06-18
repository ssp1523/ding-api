package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.conf.DingDepartmentConf;
import com.ssp.ding.conf.TypeReferenceConf;
import com.ssp.ding.request.DingDepartmentCreateRequest;
import com.ssp.ding.request.DingDepartmentUpdateRequest;
import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.ssp.ding.response.DingDepartmentResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.exception.DingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


/**
 * 钉钉部门管理默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 2:09 下午 2020/6/8
 */
@Slf4j
@RequiredArgsConstructor
public class DefaultDingDepartmentService extends BaseDingService implements DingDepartmentService, DingDepartmentConf {

    private final ObjectMapper objectMapper;

    @Override
    public Long create(DingDepartmentCreateRequest request) throws DingException {
        OapiDepartmentCreateRequest createRequest = convert(request, OapiDepartmentCreateRequest.class);
        OapiDepartmentCreateResponse response = execute(CREATE, createRequest);
        return response.getId();
    }

    @Override
    public Long update(Long id, DingDepartmentUpdateRequest request, Locale lang) throws DingException {
        Assert.notNull(id, "id 必输");

        OapiDepartmentUpdateRequest updateRequest = convert(request, OapiDepartmentUpdateRequest.class);
        updateRequest.setLang(lang.toString());
        updateRequest.setId(id);
        OapiDepartmentUpdateResponse response = execute(UPDATE, updateRequest);

        return response.getId();
    }


    @Override
    public void delete(Long id) throws DingException {
        Assert.notNull(id, "id 必输");

        OapiDepartmentDeleteRequest request = new OapiDepartmentDeleteRequest();
        request.setId(String.valueOf(id));
        execute(DELETE, request);
    }

    @Override
    public List<Long> listIds(Long parentId) throws DingException {
        Assert.notNull(parentId, "parentId 必输");

        OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
        request.setId(String.valueOf(parentId));
        OapiDepartmentListIdsResponse response = execute(LIST_IDS, request);
        return response.getSubDeptIdList();
    }

    @Override
    public List<DingDepartmentResponse> list(Long parentId, Boolean fetchChild) throws DingException {
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        request.setId(String.valueOf(parentId));
        OapiDepartmentListResponse response = execute(LIST, request);
        List<OapiDepartmentListResponse.Department> departments = response.getDepartment();
        if (CollUtil.isEmpty(departments)) {
            return Collections.emptyList();
        }

        return departments.stream()
                .map(department -> convert(department, DingDepartmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public DingDepartmentDetailResponse get(Long id) throws DingException {
        Assert.notNull(id, "id 必输");
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        request.setId(String.valueOf(id));
        OapiDepartmentGetResponse response = execute(GET, request);
        return convert(response, DingDepartmentDetailResponse.class);
    }

    @Override
    public List<Long> listParentDeptsByDept(Long id) throws DingException {
        Assert.notNull(id, "id 必输");
        OapiDepartmentListParentDeptsByDeptRequest request = new OapiDepartmentListParentDeptsByDeptRequest();
        request.setId(String.valueOf(id));
        OapiDepartmentListParentDeptsByDeptResponse response = execute(LIST_PARENT_DEPTS_BY_DEPT, request);
        return response.getParentIds();
    }

    @Override
    public List<List<Long>> listParentDepts(String userId) throws DingException {
        Assert.notBlank(userId, "userId 必输");

        OapiDepartmentListParentDeptsRequest request = new OapiDepartmentListParentDeptsRequest();
        request.setUserId(userId);
        OapiDepartmentListParentDeptsResponse response = execute(LIST_PARENT_DEPTS, request);
        String json = response.getDepartment();
        try {
            return objectMapper.readValue(json, TypeReferenceConf.LIST_LIST_LONG);
        } catch (IOException e) {
            log.error("解析json错误,json:{},错误原因:{}", json, e.getMessage(), e);
            throw new DingException(e.getMessage(), e);
        }

    }
}
