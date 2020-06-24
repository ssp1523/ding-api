package com.ssp.ding.event;

import lombok.Getter;

import java.util.List;

/**
 * 角色回调
 *
 * @author: sunshaoping
 * @date: Create by in 1:43 下午 2020/6/23
 */
@Getter
public class RoleCallbackSpringEvent extends CallbackSpringEvent {

    private final List<Long> roleIds;

    public RoleCallbackSpringEvent(String eventType, List<Long> roleIds) {
        super(eventType);
        this.roleIds = roleIds;
    }
}
