package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingWorkRecordRequest;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingWorkRecordResponse;

/**
 * 待办任务实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:03 下午 2020/7/7
 */
public class DefaultDingWorkRecordService implements DingWorkRecordService{
    @Override
    public String add(DingWorkRecordRequest workRecordRequest) throws DingException {
        return null;
    }

    @Override
    public void update(String userId, String recordId) throws DingException {

    }

    @Override
    public DingPage<DingWorkRecordResponse> getByUserId(DingPageable pageable, String userId, Integer status) throws DingException {
        return null;
    }
}
