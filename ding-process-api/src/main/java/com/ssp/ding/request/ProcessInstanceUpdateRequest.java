package com.ssp.ding.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.DingProcessWorkRecordService;
import com.ssp.ding.ProcessResult;
import com.ssp.ding.ProcessStatus;
import lombok.Builder;
import lombok.Getter;

/**
 * @author: sunshaoping
 * @date: Create by in 3:05 下午 2020/6/17
 */
@Getter
@Builder
public class ProcessInstanceUpdateRequest {

    /**
     * 任务结果，分为agree和refuse
     */
    @JsonProperty("result")
    private final ProcessResult result;

    /**
     * 实例状态，分为 COMPLETED, TERMINATED
     */
    @JsonProperty("status")
    private final ProcessStatus status;
    /**
     * 实例id。必须通过{@link DingProcessWorkRecordService#create(ProcessInstanceRequest) 创建待办实例接口}获取
     */
    private final String processInstanceId;
}
