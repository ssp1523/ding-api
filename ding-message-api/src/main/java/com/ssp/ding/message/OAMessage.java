package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.enumeration.MsgType;
import com.ssp.ding.message.oa.OABody;
import com.ssp.ding.message.oa.OAHead;
import lombok.Builder;
import lombok.Getter;

/**
 * OA消息
 *
 * @author: sunshaoping
 * @date: Create by in 8:27 下午 2020/6/15
 */
@Builder
@Getter
public class OAMessage extends DingMessage {

    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接
     */
    @JsonProperty("message_url")
    private final String messageUrl;
    /**
     * PC端点击消息时跳转到的地址
     */
    @JsonProperty("pc_message_url")
    private final String pcMessageUrl;

    /**
     * 消息头部内容
     */
    @JsonProperty("head")
    private final OAHead head;
    /**
     * 消息体
     */
    @JsonProperty("body")
    private final OABody body;

    @Override
    public MsgType getMsgType() {
        return MsgType.OA;
    }

}
