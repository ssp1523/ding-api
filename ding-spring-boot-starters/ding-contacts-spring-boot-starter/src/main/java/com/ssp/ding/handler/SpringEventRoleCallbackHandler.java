package com.ssp.ding.handler;

import com.google.common.collect.ImmutableSet;
import com.ssp.ding.event.RoleCallbackSpringEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;
import java.util.Set;

/**
 * 基于spring 事件实现的角色变更回调
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/23
 */

public class SpringEventRoleCallbackHandler extends RoleCallbackHandler implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public static final Set<String> ALL_EVENT =
            ImmutableSet.of(LABEL_USER_CHANGE, LABEL_CONF_ADD, LABEL_CONF_DEL, LABEL_CONF_MODIFY);

    @Override
    public boolean support(String eventType) {
        return ALL_EVENT.contains(eventType);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    protected void roleCallback(String eventType, List<Long> roleIds) {
        publisher.publishEvent(new RoleCallbackSpringEvent(eventType, roleIds));
    }
}
