package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author: sunshaoping
 * @date: Create by in 2:25 下午 2020/6/19
 */
@NoArgsConstructor
@Data
public class DingScheduleUserResponse {
    /**
     * 排班绑定的审批单id
     */
    @JsonProperty("approve_id")
    private Long approveId;
    /**
     * 卡点类型
     * <p>
     * OnDuty：上班
     * <p>
     * OffDuty：下班
     */
    @JsonProperty("check_type")
    private String checkType;
    /**
     * 考勤组id
     */
    @JsonProperty("group_id")
    private Long groupId;
    /**
     * 排班id
     */
    @JsonProperty("id")
    private Long id;
    /**
     * Y:当天排休
     */
    @JsonProperty("is_rest")
    private String isRest;
    /**
     * 计划打卡时间
     */
    @JsonProperty("plan_check_time")
    private LocalDateTime planCheckTime;

    /**
     * 工作日，代表具体哪一天的排班
     */
    @JsonProperty("work_date")
    private LocalDateTime workDate;


    /**
     * 最后更新时间
     */
    private LocalDateTime gmtModified;
    /**
     * 企业id
     */
    private String corpId;
    /**
     * 打卡时间
     */
    private LocalDateTime checkDateTime;
    /**
     * 允许迟到早退等规则调整后的计划打卡时间
     */
    private LocalDateTime baseCheckTime;
    /**
     * 班次名称
     */
    private LocalDateTime className;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 员工id
     */
    private String userId;
    /**
     * 排班绑定的假勤审批类型
     * <p>
     * 1：加班，2：出差，3：请假
     */
    private Integer approveBizType;
    /**
     * 排班关联的班次设置id
     */
    private Long classSettingId;
    /**
     * 排班绑定的假勤审批单名称
     */
    private String approveTagName;
    /**
     * 扩展字段
     */
    private Map<String, Object> features;
    /**
     * 排班绑定的班次id，该字段为空或者小于0时代表当天未排班
     */
    private Long classId;
    /**
     * 结束打卡时间
     */
    private LocalDateTime checkEndTime;
    /**
     * 开始打卡时间
     */
    private LocalDateTime checkBeginTime;
}
