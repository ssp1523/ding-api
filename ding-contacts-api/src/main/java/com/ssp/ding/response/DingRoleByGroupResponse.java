package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 角色
 *
 * @author: sunshaoping
 * @date: Create by in 11:36 上午 2020/6/11
 */
@Data
@Builder
public class DingRoleByGroupResponse {
    /**
     * 角色id
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
}
