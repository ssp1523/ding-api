package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 钉钉角色
 *
 * @author: sunshaoping
 * @date: Create by in 5:29 下午 2020/6/8
 */
@Data
@Builder
public class DingRole {
    /**
     * 角色组名称
     */
    private String groupName;
    /**
     * 角色id
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;

}
