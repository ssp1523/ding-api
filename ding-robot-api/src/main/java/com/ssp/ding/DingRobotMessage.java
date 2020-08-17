package com.ssp.ding;

/**
 * 钉钉机器人消息
 *
 * @author: sunshaoping
 * @date: Create by in 10:21 上午 2020/7/21
 */
public interface DingRobotMessage<T> {
    /**
     * 消息类型
     */
    String getMsgType();

    /**
     * 消息体
     */
    T getBody();

    static DingActionCardRobotMessage.DingActionCardRobotMessageBuilder actionCard() {
        return DingActionCardRobotMessage.builder();
    }
}
