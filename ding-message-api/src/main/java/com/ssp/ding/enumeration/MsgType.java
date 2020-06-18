package com.ssp.ding.enumeration;

import lombok.Getter;

/**
 * 消息枚举
 *
 * @author: sunshaoping
 * @date: Create by in 6:06 下午 2020/6/15
 */
@Getter
public enum MsgType {

    TEXT("text"),
    IMAGE("image"),
    VOICE("voice"),
    FILE("file"),
    LINK("link"),
    OA("oa"),
    MARKDOWN("markdown"),
    ACTION_CARD("action_card");

    private final String type;

    MsgType(String type) {this.type = type;}
}
