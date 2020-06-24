package com.ssp.ding.event;

import org.springframework.context.ApplicationEvent;

/**
 * spring 回调事件
 *
 * @author: sunshaoping
 * @date: Create by in 1:38 下午 2020/6/23
 */
public abstract class CallbackSpringEvent extends ApplicationEvent {

    /**
     * @param source 事件类型
     */
    public CallbackSpringEvent(String source) {
        super(source);
    }

    /**
     * 事件类型
     */
    @Override
    public String getSource() {
        return (String) super.getSource();
    }
}
