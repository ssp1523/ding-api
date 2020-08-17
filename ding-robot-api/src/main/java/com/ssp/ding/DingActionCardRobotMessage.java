package com.ssp.ding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

/**
 * link类型消息
 *
 * @author: sunshaoping
 * @date: Create by in 1:46 下午 2020/7/21
 */

@Getter
@Builder
public class DingActionCardRobotMessage implements DingRobotMessage<DingActionCardRobotMessage> {
    /**
     * 首屏会话透出的展示内容
     */
    private final String title;
    /**
     * markdown格式的消息
     */
    private final String text;

    /**
     * 按钮 列表
     */
    @Singular
    private final List<DingActionCardButton> btns;

    /**
     * 0-按钮竖直排列，1-按钮横向排列
     */

    private final String btnOrientation;


    @Override
    @JsonIgnore
    public String getMsgType() {
        return "feedCard";
    }



    @Override
    @JsonIgnore
    public DingActionCardRobotMessage getBody() {
        return this;
    }
}
