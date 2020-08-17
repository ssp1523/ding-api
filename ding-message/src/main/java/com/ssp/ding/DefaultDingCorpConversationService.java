package com.ssp.ding;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageCorpconversationGetsendprogressRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationGetsendresultRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationRecallRequest;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiMessageCorpconversationGetsendprogressResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationGetsendresultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.request.DingCorpConversationRequest;
import com.ssp.ding.response.DingSendProgressResponse;
import com.ssp.ding.response.DingSendResultResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static com.ssp.ding.DingCorpConversationService.Api.*;

/**
 * 工作通知消息默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:35 下午 2020/6/24
 */
public class DefaultDingCorpConversationService extends BaseDingService implements DingCorpConversationService {

    private final ObjectMapper objectMapper;

    private final DingMediaService dingMediaService;


    public DefaultDingCorpConversationService(DingClient dingClient, ConversionService conversionService, ObjectMapper objectMapper, DingMediaService dingMediaService) {
        super(dingClient, conversionService);
        this.objectMapper = objectMapper;
        this.dingMediaService = dingMediaService;
    }


    @Override
    public DingMessageSender<Long> asyncSendV2(DingCorpConversationRequest request) {
        List<String> userIdList = request.getUserIdList();
        Assert.notEmpty(userIdList, "userIdList 必输");
        List<Long> deptIdList = request.getDeptIdList();
        return new JacksonDingMessageSender<>(objectMapper,
                msg -> {
                    OapiMessageCorpconversationAsyncsendV2Request req = new OapiMessageCorpconversationAsyncsendV2Request();
                    req.setUseridList(String.join(DingConf.COMMA, userIdList));
                    req.setAgentId(request.getAgentId());
                    req.setToAllUser(request.getToAllUser());
                    req.setDeptIdList(StrUtil.join(DingConf.COMMA, deptIdList.toArray()));
                    req.setMsg(msg);
                    OapiMessageCorpconversationAsyncsendV2Response response = execute(ASYNC_SEND_V2, req);
                    return response.getTaskId();

                }).mediaService(dingMediaService);
    }

    @Override
    public DingSendProgressResponse getSendProgress(Long agentId, Long taskId) {
        OapiMessageCorpconversationGetsendprogressRequest request = new OapiMessageCorpconversationGetsendprogressRequest();
        request.setAgentId(agentId);
        request.setTaskId(taskId);
        OapiMessageCorpconversationGetsendprogressResponse response =
                execute(GET_SEND_PROGRESS, request);
        OapiMessageCorpconversationGetsendprogressResponse.AsyncSendProgress progress = response.getProgress();

        return convert(progress, DingSendProgressResponse.class);
    }

    @Override
    public DingSendResultResponse getSendResult(Long agentId, Long taskId) {
        OapiMessageCorpconversationGetsendresultRequest request = new OapiMessageCorpconversationGetsendresultRequest();
        request.setAgentId(agentId);
        request.setTaskId(taskId);
        OapiMessageCorpconversationGetsendresultResponse response = execute(GET_SEND_RESULT, request);
        return convert(response, DingSendResultResponse.class);
    }

    @Override
    public void recall(Long agentId, Long taskId) {
        OapiMessageCorpconversationRecallRequest request = new OapiMessageCorpconversationRecallRequest();
        request.setAgentId(agentId);
        request.setMsgTaskId(taskId);
        execute(RECALL, request);
    }
}
