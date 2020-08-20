package com.ssp.ding;

import com.dingtalk.api.request.*;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceCspaceInfoResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.dingtalk.api.response.OapiProcessinstanceListidsResponse;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingCursorPageable;
import com.ssp.ding.request.DingProcessInstanceCreateRequest;
import com.ssp.ding.request.DingProcessInstanceListIdsRequest;
import com.ssp.ding.request.GrantCspaceRequest;
import com.ssp.ding.response.DingCursorPage;
import com.ssp.ding.response.ProcessInstanceDetailResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;

import static com.ssp.ding.DingProcessInstanceService.Api.*;
import static com.ssp.ding.utils.NumberConvertUtils.toLong;

/**
 * 工作流实例实现
 *
 * @author: sunshaoping
 * @date: Create by in 3:58 下午 2020/7/7
 */
public class DefaultDingProcessInstanceService extends BaseDingService implements DingProcessInstanceService {


    public DefaultDingProcessInstanceService(DingClient dingClient) {
        super(dingClient);
    }

    @Override
    public String create(DingProcessInstanceCreateRequest createRequest) throws DingException {

        OapiProcessinstanceCreateRequest request = convert(createRequest, OapiProcessinstanceCreateRequest.class);

        OapiProcessinstanceCreateResponse response = execute(CREATE, request);

        return response.getProcessInstanceId();
    }

    @Override
    public DingCursorPage<String> listIds(DingCursorPageable pageable, DingProcessInstanceListIdsRequest listIdsRequest) throws DingException {
        OapiProcessinstanceListidsRequest request = convert(listIdsRequest, OapiProcessinstanceListidsRequest.class);
        request.setCursor(pageable.getCursor());
        request.setSize(toLong(pageable.getSize()));

        OapiProcessinstanceListidsResponse response = execute(LIST_IDS, request);
        OapiProcessinstanceListidsResponse.PageResult result = response.getResult();
        return new DingCursorPage<>(result.getNextCursor(), result.getList());
    }

    @Override
    public ProcessInstanceDetailResponse get(String processInstanceId) throws DingException {
        OapiProcessinstanceGetRequest request = new OapiProcessinstanceGetRequest();
        request.setProcessInstanceId(processInstanceId);
        OapiProcessinstanceGetResponse response = execute(GET, request);

        return convert(response, ProcessInstanceDetailResponse.class);
    }

    @Override
    public Long cspaceInfo(String userId) throws DingException {
        OapiProcessinstanceCspaceInfoRequest req = new OapiProcessinstanceCspaceInfoRequest();
        req.setUserId(userId);
        OapiProcessinstanceCspaceInfoResponse rsp = execute(CSPACE_INFO, req);
        OapiProcessinstanceCspaceInfoResponse.AppSpaceResponse result = rsp.getResult();

        return result.getSpaceId();
    }

    @Override
    public void cspacePreview(GrantCspaceRequest cspaceRequest) throws DingException {
        OapiProcessinstanceCspacePreviewRequest request = convert(cspaceRequest, OapiProcessinstanceCspacePreviewRequest.class);
        execute(CSPACE_PREVIEW, request);

    }
}
