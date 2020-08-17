package com.ssp.ding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

/**
 * link类型消息
 *
 * @author: sunshaoping
 * @date: Create by in 1:46 下午 2020/7/21
 */

@Getter
@Builder
public class DingSingleActionCardRobotMessage implements DingRobotMessage<DingSingleActionCardRobotMessage> {
    /**
     * 首屏会话透出的展示内容
     */
    private final String title;
    /**
     * markdown格式的消息
     */
    private final String text;

    /**
     * 单个按钮的标题。(设置此项和singleURL后btns无效)
     */
    private final String singleTitle;
    /**
     * 点击singleTitle按钮触发的URL
     */
    private final String singleURL;

    /**
     * 0-按钮竖直排列，1-按钮横向排列
     */

    private final String btnOrientation;


    @Override
    @JsonIgnore
    public String getMsgType() {
        return "actionCard";
    }


    @Override
    @JsonIgnore
    public DingSingleActionCardRobotMessage getBody() {
        return this;
    }
}
