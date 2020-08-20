package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.enumeration.MsgType;
import lombok.Getter;

/**
 * markdown消息
 *
 * @author: sunshaoping
 * @date: Create by in 7:40 下午 2020/6/15
 */
@Getter
public class MarkdownMessage extends DingMessage {
    /**
     * 首屏会话透出的展示内容
     */
    @JsonProperty("title")
    private final String title;
    /**
     * markdown格式的消息，建议500字符以内
     */
    @JsonProperty("text")
    private final String text;

    public MarkdownMessage(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.MARKDOWN;
    }
}
