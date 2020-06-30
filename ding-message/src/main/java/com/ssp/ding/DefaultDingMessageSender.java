package com.ssp.ding;

import com.ssp.ding.message.*;

import java.time.Duration;

/**
 * 默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 5:22 下午 2020/6/24
 */
public abstract class DefaultDingMessageSender<T> implements DingMessageSender<T> {

    private DingMediaService dingMediaService;


    @Override
    public DingMediaService mediaService() {
        return dingMediaService;
    }

    @Override
    public T sendTextMessage(String content) {
        return sendMessage(new TextMessage(content));
    }

    @Override
    public T sendImageMessage(String mediaId) {
        return sendMessage(new ImageMessage(mediaId));
    }

    @Override
    public T sendVoiceMessage(String mediaId, Duration duration) {
        return sendMessage(new VoiceMessage(mediaId, duration));
    }

    @Override
    public T sendFileMessage(String mediaId) {
        return sendMessage(new FileMessage(mediaId));
    }

    @Override
    public T sendLinkMessage(LinkMessage linkMessage) {
        return sendMessage(linkMessage);
    }

    @Override
    public T sendOAMessage(OAMessage message) {
        return sendMessage(message);
    }

    @Override
    public T sendMarkdownMessage(String title, String text) {
        return sendMessage(new MarkdownMessage(title, text));
    }

    @Override
    public T sendActionCardMessage(ActionCardMessage message) {
        return sendMessage(message);
    }

    public DefaultDingMessageSender<T> mediaService(DingMediaService dingMediaService) {
        this.dingMediaService = dingMediaService;
        return this;
    }
}
