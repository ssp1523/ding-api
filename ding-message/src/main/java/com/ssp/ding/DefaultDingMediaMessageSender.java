package com.ssp.ding;

import lombok.RequiredArgsConstructor;

import java.time.Duration;

/**
 * 发送媒体消息 默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 1:57 下午 2020/6/30
 */
@RequiredArgsConstructor
public class DefaultDingMediaMessageSender<T> implements DingMediaMessageSender<T> {

    private final String mediaId;

    private final DingMessageSender<T> dingMessageSender;


    @Override
    public T sendImageMessage() {
        return dingMessageSender.sendImageMessage(mediaId);
    }

    @Override
    public T sendVoiceMessage(Duration duration) {
        return dingMessageSender.sendVoiceMessage(mediaId, duration);
    }

    @Override
    public T sendFileMessage() {
        return dingMessageSender.sendFileMessage(mediaId);
    }
}
