package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.ProcessResult;
import com.ssp.ding.ProcessStatus;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 工作流实例详情信息
 *
 * @author: sunshaoping
 * @date: Create by in 6:01 下午 2020/6/17
 */
@Data
public class ProcessInstanceDetailResponse {


    /**
     * 审批附属实例列表，当已经通过的审批实例被修改或撤销，会生成一个新的实例，作为原有审批实例的附属。
     * <p>
     * 如果想知道当前已经通过的审批实例的状态，可以依次遍历它的附属列表，查询里面每个实例的biz_action
     */
    @JsonProperty("attached_process_instance_ids")
    private List<String> attachedProcessInstanceIds;
    /**
     * 审批实例业务动作，
     * MODIFY 表示该审批实例是基于原来的实例修改而来，
     * REVOKE 表示该审批实例对原来的实例进行撤销，
     * NONE 表示正常发起
     */
    @JsonProperty("biz_action")
    private BizAction bizAction;
    /**
     * 审批实例业务编号
     */
    @JsonProperty("business_id")
    private String businessId;
    /**
     * 抄送人。审批附带抄送人时才返回该字段。
     */
    @JsonProperty("cc_userids")
    private List<String> ccUserIds;
    /**
     * 开始时间
     */
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    /**
     * 结束时间
     */
    @JsonProperty("finish_time")
    private LocalDateTime finishTime;

    /**
     * 操作记录列表
     */
    @JsonProperty("operation_records")
    private List<OperationRecord> operationRecords;
    /**
     * 发起部门
     */
    @JsonProperty("originator_dept_id")
    private Long originatorDeptId;
    /**
     * 发起部门
     */
    @JsonProperty("originator_dept_name")
    private String originatorDeptName;
    /**
     * 发起人
     */
    @JsonProperty("originator_userid")
    private String originatorUserId;
    /**
     * 审批结果，分为 agree 和 refuse
     */
    @JsonProperty("result")
    private ProcessResult result;
    /**
     * 审批状态，分为
     * <p>
     * NEW（新创建）
     * <p>
     * RUNNING（运行中）
     * <p>
     * TERMINATED（被终止）
     * <p>
     * COMPLETED（完成）
     */
    @JsonProperty("status")
    private ProcessStatus status;
    /**
     * 已审批任务列表，可以通过此列表获取已审批人
     */
    @JsonProperty("tasks")
    private List<TaskTop> tasks;
    /**
     * 审批实例标题
     */
    @JsonProperty("title")
    private String title;
}
