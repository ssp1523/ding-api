package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 角色下的员工列表
 *
 * @author: sunshaoping
 * @date: Create by in 4:34 下午 2020/6/9
 */
@Data
@Builder
public class RoleUserSimpleResponse {

    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工id
     */
    private String userId;

    /**
     * 管理范围
     */
    private List<ManageScopeResponse> manageScopes;
}
