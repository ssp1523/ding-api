package com.ssp.ding;

import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.request.OapiChatGetReadListRequest;
import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.request.OapiMessageSendToConversationRequest;
import com.dingtalk.api.response.OapiChatGetReadListResponse;
import com.dingtalk.api.response.OapiChatSendResponse;
import com.dingtalk.api.response.OapiMessageSendToConversationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingCursorPageable;
import com.ssp.ding.response.DingCursorPage;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import org.springframework.core.convert.ConversionService;

import java.util.List;

/**
 * 群消息实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:35 下午 2020/6/24
 */
public class DefaultDingMessageService extends BaseDingService implements DingMessageService {

    private final ObjectMapper objectMapper;

    private final DingMediaService dingMediaService;

    protected DefaultDingMessageService(DingClient dingClient, ConversionService conversionService, ObjectMapper objectMapper, DingMediaService dingMediaService) {
        super(dingClient, conversionService);
        this.objectMapper = objectMapper;
        this.dingMediaService = dingMediaService;
    }


    @Override
    public DingMessageSender<String> sendChat(String chatId) {
        return new JacksonDingMessageSender<>(objectMapper,
                msg -> {
                    OapiChatSendRequest request = new OapiChatSendRequest();
                    request.setChatid(chatId);
                    request.setMsg(msg);
                    OapiChatSendResponse response = execute("/chat/send", request);
                    return response.getMessageId();
                }).mediaService(dingMediaService);
    }

    @Override
    public DingCursorPage<String> getReadList(DingCursorPageable pageable, String messageId) {

        OapiChatGetReadListRequest request = new OapiChatGetReadListRequest();
        request.setMessageId(messageId);
        request.setCursor(pageable.getCursor());
        request.setSize(Long.valueOf(pageable.getSize()));
        OapiChatGetReadListResponse response = execute("/chat/getReadList", request);

        return new DingCursorPage<>(request.getCursor(), response.getReadUserIdList());
    }

    @Override
    public DingMessageSender<List<String>> sendToConversation(String sender, String cid) throws DingException {

        return new JacksonDingMessageSender<>(objectMapper,
                msg -> {
                    OapiMessageSendToConversationRequest req = new OapiMessageSendToConversationRequest();
                    req.setSender(sender);
                    req.setCid(cid);
                    req.setMsg(msg);
                    OapiMessageSendToConversationResponse response = execute("/message/send_to_conversation", req);
                    String receiver = response.getReceiver();
                    return StrUtil.splitTrim(receiver, DingConf.VERTICAL_BAR);
                }).mediaService(dingMediaService);
    }

    @Override
    public DingMediaService mediaService() {
        return dingMediaService;
    }

}

