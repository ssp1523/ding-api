package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssp.ding.enumeration.MsgType;

/**
 * 消息基类
 *
 * @author: sunshaoping
 * @date: Create by in 6:43 下午 2020/6/15
 */
public abstract class DingMessage {

    /**
     * 消息类型
     */
    @JsonIgnore
    public abstract MsgType getMsgType();

}
