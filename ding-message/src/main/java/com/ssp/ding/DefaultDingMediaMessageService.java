package com.ssp.ding;

import com.ssp.ding.enumeration.MediaType;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.response.DingMediaResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * 发送媒体文件消息 默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 1:35 下午 2020/6/30
 */
@RequiredArgsConstructor
public class DefaultDingMediaMessageService implements DingMediaMessageService {

    @Delegate
    private final DingMediaService dingMediaService;

    @Delegate
    private final DingMessageService dingMessageService;

    @Override
    public DingMediaMessageSender<String> sendAndUpload(String chatId, MediaType mediaType, Resource resource) throws DingException {
        DingMediaResponse response = this.upload(mediaType, resource);
        String mediaId = response.getMediaId();
        DingMessageSender<String> messageSender = this.send(chatId);
        return new DefaultDingMediaMessageSender<>(mediaId, messageSender);
    }

    @Override
    public DingMediaMessageSender<List<String>> sendAndUploadToConversation(String sender, String cid, MediaType mediaType, Resource resource) throws DingException {
        DingMediaResponse response = this.upload(mediaType, resource);
        String mediaId = response.getMediaId();
        DingMessageSender<List<String>> messageSender = this.sendToConversation(sender, cid);
        return new DefaultDingMediaMessageSender<>(mediaId, messageSender);

    }
}
