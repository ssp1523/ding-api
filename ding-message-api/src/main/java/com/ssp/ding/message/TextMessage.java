package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.enumeration.MsgType;
import lombok.Getter;

/**
 * 文本消息
 *
 * @author: sunshaoping
 * @date: Create by in 7:40 下午 2020/6/15
 */
@Getter
public class TextMessage extends DingMessage {

    @JsonProperty("content")
    private final String content;

    public TextMessage(String content) {
        this.content = content;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.TEXT;
    }
}
