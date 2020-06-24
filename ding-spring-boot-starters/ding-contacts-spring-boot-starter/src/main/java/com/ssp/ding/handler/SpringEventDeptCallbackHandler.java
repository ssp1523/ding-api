package com.ssp.ding.handler;

import com.google.common.collect.ImmutableSet;
import com.ssp.ding.event.DeptCallbackSpringEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;
import java.util.Set;

/**
 * 基于spring 事件实现的部门变更回调
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/23
 */
public class SpringEventDeptCallbackHandler extends DeptCallbackHandler implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public static final Set<String> ALL_EVENT =
            ImmutableSet.of(ORG_DEPT_CREATE, ORG_DEPT_MODIFY, ORG_DEPT_REMOVE);


    @Override
    public boolean support(String eventType) {
        return ALL_EVENT.contains(eventType);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    protected void deptCallback(String eventType, List<Long> deptIds) {
        publisher.publishEvent(new DeptCallbackSpringEvent(eventType, deptIds));
    }
}
