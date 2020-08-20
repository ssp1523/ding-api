package com.ssp.ding.convert;

import com.dingtalk.api.response.OapiCallBackGetCallBackFailedResultResponse;
import com.ssp.ding.response.DingCallBackFailedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
public class DingCallBackFailedResponseConverter implements Converter<OapiCallBackGetCallBackFailedResultResponse.Failed, DingCallBackFailedResponse> {

    @Override
    public DingCallBackFailedResponse convert(OapiCallBackGetCallBackFailedResultResponse.Failed failed) {


        return DingCallBackFailedResponse.builder()
                .bpmsInstanceChange(failed.getBpmsInstanceChange())
                .callBackTag(failed.getCallBackTag())
                .bpmsTaskChange(failed.getBpmsTaskChange())
                .checkIn(failed.getCheckIn())
                .data(failed.getData())
                .eventTime(failed.getEventTime())
                .orgAdminAdd(failed.getOrgAdminAdd())
                .orgAdminRemove(failed.getOrgAdminRemove())
                .orgChange(failed.getOrgChange())
                .orgDeptCreate(failed.getOrgDeptCreate())
                .orgDeptModify(failed.getOrgDeptModify())
                .orgDeptRemove(failed.getOrgDeptRemove())
                .userAddOrg(failed.getUserAddOrg())
                .userLeaveOrg(failed.getUserLeaveOrg())
                .userModifyOrg(failed.getUserModifyOrg())
                .build();
    }
}
