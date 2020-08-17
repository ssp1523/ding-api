package com.ssp.ding;

import com.ssp.ding.request.*;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingProcessTaskResponse;
import com.ssp.ding.response.DingUserTaskResponse;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 工作流待办事项实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:03 下午 2020/7/7
 */
public class DefaultDingProcessWorkRecordTaskService implements DingProcessWorkRecordTaskService{
    @Override
    public List<DingProcessTaskResponse> create(DingProcessTaskCreateRequest createRequest) {
        return null;
    }

    @Override
    public void update(@Nullable Long agentId, String processInstanceId, List<TaskTopRequest> tasks) {

    }

    @Override
    public void cancel(DingCancelRequest request) {

    }

    @Override
    public DingPage<DingUserTaskResponse> query(DingPageable pageable, DingUserTaskQueryRequest queryRequest) {
        return null;
    }
}
