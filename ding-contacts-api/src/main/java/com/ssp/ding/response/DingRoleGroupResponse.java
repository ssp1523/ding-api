package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 角色分组
 *
 * @author: sunshaoping
 * @date: Create by in 4:27 下午 2020/6/9
 */
@Data
@Builder
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
     * <p>
     * {@link DingRoleResponse#getGroupId()} 原接口不存在该数据,框架后来添加的
     */
    private List<DingRoleResponse> roles;
}
