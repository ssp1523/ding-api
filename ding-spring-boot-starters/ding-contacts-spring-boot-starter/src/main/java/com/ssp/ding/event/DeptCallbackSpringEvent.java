package com.ssp.ding.event;

import lombok.Getter;

import java.util.List;

/**
 * 用户回调事件
 *
 * @author: sunshaoping
 * @date: Create by in 11:28 上午 2020/6/23
 */
@Getter
public class DeptCallbackSpringEvent extends CallbackSpringEvent {

    /**
     * 用户变更的用户ID列表
     */
    private final List<Long> deptIds;


    public DeptCallbackSpringEvent(String source, List<Long> deptIds) {
        super(source);
        this.deptIds = deptIds;
    }

}
