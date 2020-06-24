package com.ssp.ding.handler;

import com.google.common.collect.ImmutableSet;
import com.ssp.ding.event.UserCallbackSpringEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;
import java.util.Set;

/**
 * 基于spring 事件实现的用户变更回调
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/23
 */
public class SpringEventUserCallbackHandler extends UserCallbackHandler implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public static final Set<String> USER_ALL_EVENT =
            ImmutableSet.of(USER_ADD_ORG, USER_ACTIVE_ORG, USER_LEAVE_ORG, USER_MODIFY_ORG, ORG_ADMIN_REMOVE, ORG_ADMIN_ADD);

    @Override
    protected void callback(String eventType, List<String> userIds) {
        publisher.publishEvent(new UserCallbackSpringEvent(eventType, userIds));
    }

    @Override
    public boolean support(String eventType) {
        return USER_ALL_EVENT.contains(eventType);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
