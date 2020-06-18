package com.ssp.ding.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.ProcessResult;
import com.ssp.ding.ProcessStatus;
import lombok.Builder;
import lombok.Getter;

/**
 * 任务
 *
 * @author: sunshaoping
 * @date: Create by in 3:46 下午 2020/6/17
 */
@Getter
@Builder
public class TaskTopRequest {

    /**
     * 任务结果，分为agree和refuse
     */
    @JsonProperty("result")
    private final ProcessResult result;
    /**
     * 任务状态，分为CANCELED和COMPLETED
     */
    @JsonProperty("status")
    private final ProcessStatus status;
    /**
     * 任务id
     */
    @JsonProperty("task_id")
    private final Long taskId;

}
