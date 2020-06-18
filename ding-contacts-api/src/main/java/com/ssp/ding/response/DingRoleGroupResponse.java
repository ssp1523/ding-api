package com.ssp.ding.response;

import lombok.Data;

import java.util.List;

/**
 * 角色分组
 *
 * @author: sunshaoping
 * @date: Create by in 4:27 下午 2020/6/9
 */
@Data
public class DingRoleGroupResponse {
    /**
     * 角色组id
     */
    private Long groupId;
    /**
     * 角色组名称
     */
    private String name;
    /**
     * 角色
     */
    private List<DingRoleByGroupResponse> roles;
}
