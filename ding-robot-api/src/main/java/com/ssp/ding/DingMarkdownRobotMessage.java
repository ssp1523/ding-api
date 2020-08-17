package com.ssp.ding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Nullable;

/**
 * link类型消息
 *
 * @author: sunshaoping
 * @date: Create by in 1:46 下午 2020/7/21
 */

@Getter
@Builder
public class DingMarkdownRobotMessage implements DingRobotMessage<DingMarkdownRobotMessage> {
    /**
     * 首屏会话透出的展示内容
     */
    private final String title;
    /**
     * markdown格式的消息
     */
    private final String text;


    @Override
    @JsonIgnore
    public String getMsgType() {
        return "markdown";
    }


    @Override
    @JsonIgnore
    public DingMarkdownRobotMessage getBody() {
        return this;
    }
}
