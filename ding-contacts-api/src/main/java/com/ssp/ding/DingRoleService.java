package com.ssp.ding;

import com.ssp.ding.request.DingPageable;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingRoleGroupResponse;
import com.ssp.ding.response.DingRoleResponse;
import com.ssp.ding.response.RoleUserSimpleResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 角色管理
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1
 *
 * @author: sunshaoping
 * @date: Create by in 4:13 下午 2020/6/9
 */
public interface DingRoleService {
    /**
     * 创建角色
     * <p>
     * 请求地址：https://oapi.dingtalk.com/role/add_role?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/00d61084
     *
     * @param groupId  角色组id
     * @param roleName 角色名称
     * @return 角色id
     */
    Long addRole(Long groupId, String roleName);

    /**
     * 更新角色
     * <p>
     * 请求地址：https://oapi.dingtalk.com/role/update_role?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/9eb0eba6
     *
     * @param roleId   角色id。“默认”分组内的角色不支持修改，包括：负责人、主管、主管理员、子管理员
     * @param roleName 角色名称
     */
    void updateRole(Long roleId, String roleName);

    /**
     * 删除角色
     * <p>
     * 【注意】删除角色前，需确保角色下面的员工没有被赋予这个角色
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/deleterole?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/ca40c5a5
     *
     * @param roleId 角色id。“默认”分组内的角色不支持修改，包括：负责人、主管、主管理员、子管理员
     */
    void deleteRole(Long roleId);


    /**
     * 获取角色详情
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/fc77043e
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/getrole?access_token=ACCESS_TOKEN
     *
     * @param roleId 角色Id
     */
    DingRoleResponse getRole(Long roleId);

    /**
     * 获取角色列表
     * <p>
     * 接口文档 https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/a6313fe1
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/list?access_token=ACCESS_TOKEN
     *
     * @param pageable 分页
     */
    DingPage<DingRoleGroupResponse> list(DingPageable pageable);

    /**
     * @see #list(DingPageable)
     */
    default DingPage<DingRoleGroupResponse> list() {
        return list(DingPageable.DEFAULT_20);
    }

    /**
     * 获取角色下的员工列表
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/189c3a45
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/simplelist?access_token=ACCESS_TOKEN
     *
     * @param pageable 分页
     * @param roleId   角色Id
     */
    DingPage<RoleUserSimpleResponse> simpleList(DingPageable pageable, Long roleId);

    /**
     * @see #simpleList(DingPageable, Long)
     */
    default DingPage<RoleUserSimpleResponse> simpleList(Long roleId) {
        return simpleList(DingPageable.DEFAULT_20, roleId);
    }


    /**
     * 创建角色组
     * <p>
     * 请求地址：https://oapi.dingtalk.com/role/add_role_group?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/744cb825
     *
     * @param groupName 角色组名称
     * @return 角色组id
     */
    Long addRoleGroup(String groupName);


    /**
     * 获取角色组
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/f6200f9a
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/getrolegroup?access_token=ACCESS_TOKEN
     *
     * @param groupId 角色组的Id
     */
    DingRoleGroupResponse getRoleGroup(Long groupId);


    /**
     * 批量增加员工角色
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/addrolesforemps?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/9bdcbf35
     *
     * @param roleIds 角色id list，最大列表长度：20
     * @param userIds 员工id list，最大列表长度：20
     */
    void addRolesForEmps(List<Long> roleIds, List<String> userIds);

    /**
     * 批量删除员工角色
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/removerolesforemps?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/d085371e
     *
     * @param roleIds 角色id list，最大列表长度：20
     * @param userIds 员工id list，最大列表长度：20
     */
    void removeRolesForEmps(List<Long> roleIds, List<String> userIds);


    /**
     * 设定角色成员管理范围
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/role/scope/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dnu5l1/23c66112
     *
     * @param roleId  角色id，必须是用户已经加入的角色
     * @param userId  用户id
     * @param deptIds 部门id列表，最多50个，不传则设置范围为默认值：所有人
     */
    void scopeUpdate(Long roleId, String userId, @Nullable List<Long> deptIds);

    default void scopeUpdate(Long roleId, String userId) {
        scopeUpdate(roleId, userId, null);
    }


    /**
     * 接口api
     */
    @Getter
    @RequiredArgsConstructor
    enum Api implements DingApi {

        /**
         * @see #addRole(Long, String)
         */
        ADD_ROLE("role/add_role", "创建角色"),
        /**
         * @see #updateRole(Long, String)
         */
        UPDATE_ROLE("role/update_role", "更新角色"),
        /**
         * @see #addRoleGroup(String)
         */
        ADD_ROLE_GROUP("role/add_role_group", "创建角色组"),
        /**
         * @see #deleteRole(Long)
         */
        DELETE_ROLE("topapi/role/deleterole", "删除角色"),
        /**
         * @see #getRole(Long)
         */
        GET_ROLE("topapi/role/getrole", "获取角色详情"),
        /**
         * @see #addRolesForEmps(List, List)
         */
        ADD_ROLES_FOREMPS("topapi/role/addrolesforemps", "批量增加员工角色"),
        /**
         * @see #removeRolesForEmps(List, List)
         */
        REMOVE_ROLES_FOREMPS("topapi/role/removerolesforemps", "批量删除员工角色"),
        /**
         * @see #scopeUpdate(Long, String, List)
         */
        SCOPE_UPDATE("topapi/role/scope/update", "设定角色成员管理范围"),
        /**
         * @see #list(DingPageable)
         * @see #list()
         */
        ROLE_LIST("/topapi/role/list", "获取角色列表"),
        /**
         * @see #simpleList(DingPageable, Long)
         * @see #simpleList(Long)
         */
        ROLE_SIMPLE_LIST("/topapi/role/simplelist", "获取角色下的员工列表"),
        /**
         * @see #getRoleGroup(Long)
         */
        ROLE_GET_ROLE_GROUP("/topapi/role/getrolegroup", "获取角色组"),


        ;

        private final String path;

        private final String sketch;

    }

}