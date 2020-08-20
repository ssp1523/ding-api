package com.ssp.ding;

import com.dingtalk.api.request.OapiChatCreateRequest;
import com.dingtalk.api.request.OapiChatGetRequest;
import com.dingtalk.api.request.OapiChatSubadminUpdateRequest;
import com.dingtalk.api.request.OapiChatUpdateRequest;
import com.dingtalk.api.response.OapiChatCreateResponse;
import com.dingtalk.api.response.OapiChatGetResponse;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.request.DingChatCreateRequest;
import com.ssp.ding.request.DingChatUpdateRequest;
import com.ssp.ding.response.DingChatCreateResponse;
import com.ssp.ding.response.DingChatResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;

import java.util.List;

import static com.ssp.ding.DingChatService.Api.*;

/**
 * 群会话管理 钉钉客户端实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:34 下午 2020/6/24
 */
public class DefaultDingChatService extends BaseDingService implements DingChatService {


    public DefaultDingChatService(DingClient dingClient) {
        super(dingClient);
    }

    @Override
    public DingChatCreateResponse create(DingChatCreateRequest req) {

        OapiChatCreateRequest request = convert(req, OapiChatCreateRequest.class);

        OapiChatCreateResponse response = execute(CREATE, request);
        return DingChatCreateResponse.builder()
                .chatId(response.getChatid())
                .conversationTag(response.getConversationTag())
                .build();
    }

    @Override
    public void update(String chatId, DingChatUpdateRequest req) {
        OapiChatUpdateRequest request = convert(req, OapiChatUpdateRequest.class);
        request.setChatid(chatId);
        execute(UPDATE, request);
    }

    @Override
    public DingChatResponse get(String chatId) {
        OapiChatGetRequest request = new OapiChatGetRequest();
        request.setChatid(chatId);
        OapiChatGetResponse response = execute(GET, request);
        return convert(response, DingChatResponse.class);
    }

    @Override
    public void subAdminUpdate(String chatId, List<String> userIds, Integer role) {
        OapiChatSubadminUpdateRequest req = new OapiChatSubadminUpdateRequest();
        req.setChatid(chatId);
        req.setUserids(String.join(DingConf.COMMA, userIds));
        req.setRole(Long.valueOf(role));
        execute(SUB_ADMIN_UPDATE, req);
    }
}
