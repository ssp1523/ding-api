package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.OapiProcessGetByNameResponse;
import com.dingtalk.api.response.OapiProcessGettodonumResponse;
import com.dingtalk.api.response.OapiProcessListbyuseridResponse;
import com.dingtalk.api.response.OapiProcessSaveResponse;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingSaveProcessRequest;
import com.ssp.ding.response.DingCursorPage;
import com.ssp.ding.response.DingProcessTopResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import org.springframework.core.convert.ConversionService;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.ssp.ding.DingProcessService.Api.*;

/**
 * 企业自有工作流模板实现
 *
 * @author: sunshaoping
 * @date: Create by in 3:59 下午 2020/7/7
 */
public class DefaultDingProcessService extends BaseDingService implements DingProcessService {


    public DefaultDingProcessService(DingClient dingClient) {
        super(dingClient);
    }

    @Override
    public String create(DingSaveProcessRequest request) {
        OapiProcessSaveRequest saveRequest = convert(request, OapiProcessSaveRequest.class);
        OapiProcessSaveResponse response = execute(SAVE, saveRequest);
        return response.getResult().getProcessCode();
    }

    @Override
    public void update(String processCode, DingSaveProcessRequest request) {
        request.setProcessCode(processCode);
        create(request);
    }

    @Override
    public String getByName(String name) {
        OapiProcessGetByNameRequest req = new OapiProcessGetByNameRequest();
        req.setName(name);
        OapiProcessGetByNameResponse response = execute(GET_BY_NAME, req);
        return response.getProcessCode();
    }

    @Override
    public Integer getTodoNum(String userId) {
        OapiProcessGettodonumRequest req = new OapiProcessGettodonumRequest();
        req.setUserid(userId);
        OapiProcessGettodonumResponse response = execute(GET_TODO_NUM, req);

        Long count = response.getCount();
        if (Objects.isNull(count)) {
            return 0;
        }
        return Math.toIntExact(count);
    }

    @Override

    public DingCursorPage<DingProcessTopResponse> listByUserId(DingPageable pageable, String userId) {

        OapiProcessListbyuseridRequest request = new OapiProcessListbyuseridRequest();
        request.setUserid(userId);
        request.setOffset((long) pageable.getOffset());
        request.setSize((long) pageable.getSize());

        OapiProcessListbyuseridResponse response = execute(LIST_BY_USER_ID, request);
        OapiProcessListbyuseridResponse.HomePageProcessTemplateVo result = response.getResult();
        List<OapiProcessListbyuseridResponse.ProcessTopVo> processList = result.getProcessList();
        if (CollUtil.isEmpty(processList)) {
            return DingCursorPage.empty();
        }
        List<DingProcessTopResponse> responses = processList.stream()
                .map(processTopVo -> convert(processTopVo, DingProcessTopResponse.class))
                .collect(Collectors.toList());

        return new DingCursorPage<>(result.getNextCursor(), responses);
    }

    @Override
    public void delete(@Nullable Long agentId, String processCode, @Nullable Boolean cleanRunningTask) {

        OapiProcessDeleteRequest req = new OapiProcessDeleteRequest();
        OapiProcessDeleteRequest.DeleteProcessRequest deleteProcessRequest = new OapiProcessDeleteRequest.DeleteProcessRequest();
        deleteProcessRequest.setAgentid(agentId);
        deleteProcessRequest.setProcessCode(processCode);
        deleteProcessRequest.setCleanRunningTask(cleanRunningTask);
        req.setRequest(deleteProcessRequest);
        execute(DELETE, req);

    }
}
