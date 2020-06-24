package com.ssp.ding.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 用户回调事件
 *
 * @author: sunshaoping
 * @date: Create by in 11:28 上午 2020/6/23
 */
@Getter
public class UserCallbackSpringEvent extends ApplicationEvent {

    /**
     * 用户变更的用户ID列表
     */
    private final List<String> userIds;


    public UserCallbackSpringEvent(String source, List<String> userIds) {
        super(source);
        this.userIds = userIds;
    }

    /**
     * 事件类型
     */
    @Override
    public String getSource() {
        return (String) super.getSource();
    }
}
