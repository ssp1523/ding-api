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
public class DingLinkRobotMessage implements DingRobotMessage<DingLinkRobotMessage> {
    /**
     * 消息标题
     */
    private final String title;
    /**
     * 消息内容。如果太长只会部分展示
     */
    private final String text;
    /**
     * 点击消息跳转的URL
     */
    private final String messageUrl;
    /**
     * 图片URL
     */
    @Nullable
    private final String picUrl;


    @Override
    @JsonIgnore
    public String getMsgType() {
        return "link";
    }


    @Override
    @JsonIgnore
    public DingLinkRobotMessage getBody() {
        return this;
    }
}
