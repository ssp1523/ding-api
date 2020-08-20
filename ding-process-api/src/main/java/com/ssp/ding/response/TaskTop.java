package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.ProcessStatus;

import java.time.LocalDateTime;

/**
 * 已审批任务,可以获取已审批人
 *
 * @author: sunshaoping
 * @date: Create by in 6:27 下午 2020/6/17
 */
public class TaskTop {

    /**
     * 任务处理人
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * todo 任务状态，分为 NEW（未启动），RUNNING（处理中），CANCELED（取消），COMPLETED（完成）
     */
    @JsonProperty("task_status")
    private ProcessStatus taskStatus;
    /**
     * 开始时间
     */
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    /**
     * 结束时间,当前任务结束时才会有这个字段返回。
     */
    @JsonProperty("finish_time")
    private LocalDateTime finishTime;
    /**
     * 结果，分为NONE（无），AGREE（同意），REFUSE（拒绝），REDIRECTED（转交）
     */
    @JsonProperty("task_result")
    private TaskResult taskResult;
    /**
     * 任务节点id
     */
    @JsonProperty("taskid")
    private String taskId;


}
