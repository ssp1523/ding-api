package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingRoleGroupResponse;
import com.ssp.ding.response.DingRoleResponse;
import com.ssp.ding.response.RoleUserSimpleResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.ssp.ding.DingRoleService.Api.*;
import static com.ssp.ding.conf.DingConf.COMMA;
import static com.ssp.ding.conf.DingConf.VERTICAL_BAR;


/**
 * 钉钉角色管理
 *
 * @author: sunshaoping
 * @date: Create by in 4:47 下午 2020/6/9
 */
public class DefaultDingRoleService extends BaseDingService implements DingRoleService {

    public DefaultDingRoleService(DingClient dingClient, ConversionService conversionService) {
        super(dingClient, conversionService);
    }

    @Override
    public Long addRole(Long groupId, String roleName) {
        OapiRoleAddRoleRequest req = new OapiRoleAddRoleRequest();
        req.setRoleName(roleName);
        req.setGroupId(groupId);
        OapiRoleAddRoleResponse response = execute(ADD_ROLE, req);
        return response.getRoleId();
    }

    @Override
    public void updateRole(Long roleId, String roleName) {
        OapiRoleUpdateRoleRequest req = new OapiRoleUpdateRoleRequest();
        req.setRoleId(roleId);
        req.setRoleName(roleName);
        execute(UPDATE_ROLE, req);
    }

    @Override
    public void deleteRole(Long roleId) {
        OapiRoleDeleteroleRequest request = new OapiRoleDeleteroleRequest();
        request.setRoleId(roleId);
        execute(DELETE_ROLE, request);
    }

    @Override
    public DingRoleResponse getRole(Long roleId) {
        OapiRoleGetroleRequest req = new OapiRoleGetroleRequest();
        req.setRoleId(roleId);
        OapiRoleGetroleResponse response = execute(GET_ROLE, req);
        OapiRoleGetroleResponse.OpenRole role = response.getRole();
        if (Objects.isNull(role)) {
            throw new DingException("未找到角色 roleId=" + roleId, (Throwable) null);
        }
        return convert(role, DingRoleResponse.class);

    }

    @Override
    public DingPage<DingRoleGroupResponse> list(DingPageable pageable) {
        OapiRoleListRequest request = new OapiRoleListRequest();
        request.setOffset((long) pageable.getOffset());
        request.setSize((long) pageable.getSize());

        OapiRoleListResponse response = execute(ROLE_LIST, request);
        OapiRoleListResponse.PageVo result = response.getResult();
        List<OapiRoleListResponse.OpenRoleGroup> list = result.getList();
        if (CollUtil.isEmpty(list)) {
            return DingPage.empty();
        }

        return new DingPage<>(result.getHasMore(),
                list.stream()
                        .map(openRoleGroup -> convert(openRoleGroup, DingRoleGroupResponse.class))
                        .collect(Collectors.toList())
        );
    }


    @Override
    public DingPage<RoleUserSimpleResponse> simpleList(DingPageable pageable, Long roleId) {

        OapiRoleSimplelistRequest request = new OapiRoleSimplelistRequest();
        request.setRoleId(roleId);
        request.setOffset((long) pageable.getOffset());
        request.setSize((long) pageable.getSize());

        OapiRoleSimplelistResponse response = execute(ROLE_SIMPLE_LIST, request);
        OapiRoleSimplelistResponse.PageVo result = response.getResult();
        List<OapiRoleSimplelistResponse.OpenEmpSimple> list = result.getList();
        if (CollUtil.isEmpty(list)) {
            return DingPage.empty();
        }

        return new DingPage<>(result.getHasMore(),
                list.stream()
                        .map(openEmpSimple -> convert(openEmpSimple, RoleUserSimpleResponse.class))
                        .collect(Collectors.toList())
        );
    }


    @Override
    public Long addRoleGroup(String groupName) {

        OapiRoleAddrolegroupRequest req = new OapiRoleAddrolegroupRequest();
        req.setName(groupName);
        OapiRoleAddrolegroupResponse response = execute(ADD_ROLE_GROUP, req);
        return response.getGroupId();
    }

    @Override
    public DingRoleGroupResponse getRoleGroup(Long groupId) {

        OapiRoleGetrolegroupRequest request = new OapiRoleGetrolegroupRequest();
        request.setGroupId(groupId);

        OapiRoleGetrolegroupResponse response = execute(ROLE_GET_ROLE_GROUP, request);

        DingRoleGroupResponse roleGroupResponse = convert(response.getRoleGroup(), DingRoleGroupResponse.class);
        if (Objects.isNull(roleGroupResponse.getGroupId())) {
            roleGroupResponse.setGroupId(groupId);
        }
        return roleGroupResponse;
    }

    @Override
    public void addRolesForemps(List<Long> roleIds, List<String> userIds) {
        Assert.notEmpty(roleIds, "roleIds 必输");
        Assert.notEmpty(userIds, "userIds 必输");

        OapiRoleAddrolesforempsRequest request = new OapiRoleAddrolesforempsRequest();
        request.setRoleIds(
                roleIds.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(VERTICAL_BAR))
        );
        request.setUserIds(String.join(VERTICAL_BAR, userIds));
        execute(ADD_ROLES_FOREMPS, request);
    }

    @Override
    public void removeRolesForemps(List<Long> roleIds, List<String> userIds) {
        Assert.notEmpty(roleIds, "roleIds 必输");
        Assert.notEmpty(userIds, "userIds 必输");

        OapiRoleRemoverolesforempsRequest request = new OapiRoleRemoverolesforempsRequest();
        request.setRoleIds(
                roleIds.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(VERTICAL_BAR))
        );
        request.setUserIds(String.join(VERTICAL_BAR, userIds));

        execute(REMOVE_ROLES_FOREMPS, request);
    }

    @Override
    public void scopeUpdate(String userId, Long roleId, List<Long> deptIds) {
        OapiRoleScopeUpdateRequest req = new OapiRoleScopeUpdateRequest();
        req.setUserid(userId);
        req.setRoleId(roleId);
        if (CollUtil.isNotEmpty(deptIds)) {
            req.setDeptIds(
                    deptIds.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(COMMA))
            );
        }
        execute(SCOPE_UPDATE, req);
    }
}
