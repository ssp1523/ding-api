package com.ssp.ding;

import com.ssp.ding.exception.DingException;

/**
 * 钉钉机器人服务
 * <p>
 * 请求地址：https://oapi.dingtalk.com/robot/send
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 *
 * @author: sunshaoping
 * @date: Create by in 6:57 下午 2020/7/17
 */
public interface DingRobotService {


    /**
     * 发送机器人消息
     *
     * @param message 消息内容
     * @param at      需要at的群成员
     */
    <T> void send(DingRobotMessage<T> message, DingRobotAt at) throws DingException;

    /**
     * @see #send(DingRobotMessage, DingRobotAt)
     */
    default <T> void send(DingRobotMessage<T> message) throws DingException {
        send(message, DingRobotAt.EMPTY);
    }

    /**
     * @see #sendText(String, DingRobotAt)
     */
    default void sendText(String content) {
        sendText(content, DingRobotAt.EMPTY);
    }

    /**
     * text类型 消息
     *
     * @param content 消息内容
     * @param at      需要at的群成员
     */
    void sendText(String content, DingRobotAt at);

    /**
     * markdown类型消息
     *
     * @param title 首屏会话透出的展示内容
     * @param text  markdown格式的消息
     * @param at    需要at的群成员
     */
    void sendMarkdown(String title, String text, DingRobotAt at);

    default void sendMarkdown(String title, String text) {
        sendMarkdown(title, text, DingRobotAt.EMPTY);
    }

}
