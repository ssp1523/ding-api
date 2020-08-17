package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 角色
 *
 * @author: sunshaoping
 * @date: Create by in 4:15 下午 2020/6/9
 */
@Data
@Builder
public class DingRoleResponse {

    public static final DingRoleResponse EMPTY = DingRoleResponse.builder().build();

    /**
     * 角色组id
     */
    private Long groupId;
    /**
     * 角色名称
     */
    private String name;
}
