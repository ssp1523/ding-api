package com.ssp.ding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

/**
 * link类型消息
 *
 * @author: sunshaoping
 * @date: Create by in 1:46 下午 2020/7/21
 */

@Getter
public class DingFeedCardRobotMessage implements DingRobotMessage<DingFeedCardRobotMessage> {

    private final List<Link> links;

    public DingFeedCardRobotMessage() {
        this(new ArrayList<Link>());
    }

    public DingFeedCardRobotMessage(List<Link> links) {
        this.links = links;
    }

    @Override
    @JsonIgnore
    public String getMsgType() {
        return "feedCard";
    }


    @Override
    @JsonIgnore
    public DingFeedCardRobotMessage getBody() {
        return this;
    }

    public static Link.LinkBuilder builderLink() {
        return Link.builder();
    }

    @Getter
    @Builder
    public static class Link {
        /**
         * 单条信息文本
         */
        private final String title;
        /**
         * 点击单条信息到跳转链接
         */
        private final String messageURL;

        /**
         * 单条信息后面图片的URL
         */
        private final String picURL;

    }
}
