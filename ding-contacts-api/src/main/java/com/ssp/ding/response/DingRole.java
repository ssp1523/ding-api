package com.ssp.ding.response;

import lombok.Data;

/**
 * 钉钉角色
 *
 * @author: sunshaoping
 * @date: Create by in 5:29 下午 2020/6/8
 */
@Data
public class DingRole {

    private String groupName;

    private Long id;

    private String name;

    private Long type;
}
