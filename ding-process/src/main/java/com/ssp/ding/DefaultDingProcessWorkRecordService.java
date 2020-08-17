package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.ProcessInstanceRequest;
import com.ssp.ding.request.ProcessInstanceUpdateRequest;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 工作流实例实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:02 下午 2020/7/7
 */
public class DefaultDingProcessWorkRecordService implements DingProcessWorkRecordService{
    @Override
    public String create(ProcessInstanceRequest instance) throws DingException {
        return null;
    }

    @Override
    public void update(@Nullable Long agentId, ProcessInstanceUpdateRequest instance) throws DingException {

    }

    @Override
    public void batchUpdate(Long agentId, List<ProcessInstanceUpdateRequest> instances) throws DingException {

    }
}
