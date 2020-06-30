package com.ssp.ding;

import java.time.Duration;

/**
 * 发送媒体消息
 *
 * @author: sunshaoping
 * @date: Create by in 1:54 下午 2020/6/30
 */
public interface DingMediaMessageSender<T> {


    /**
     * 图片消息
     */
    T sendImageMessage();

    /**
     * 语音消息
     *
     * @param duration 正整数，小于60，表示音频时长
     */
    T sendVoiceMessage(Duration duration);

    /**
     * 文件消息
     */
    T sendFileMessage();


}
