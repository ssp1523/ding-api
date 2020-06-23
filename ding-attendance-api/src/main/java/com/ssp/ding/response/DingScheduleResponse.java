package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * TODO 记得写注释
 *
 * @author: sunshaoping
 * @date: Create by in 3:19 下午 2020/6/18
 */
@Data
public class DingScheduleResponse {
    /**
     * 排班id
     */
    @JsonProperty("plan_id")
    private Long planId;
    /**
     * 打卡类型，OnDuty表示上班打卡，OffDuty表示下班打卡
     */
    @JsonProperty("check_type")
    private String checkType;
    /**
     * 审批id，结果集中没有的话表示没有审批单
     */
    @JsonProperty("approve_id")
    private Long approveId;
    /**
     * userId
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * 考勤班次id
     */
    @JsonProperty("class_id")
    private Long classId;
    /**
     * 班次配置id，结果集中没有的话表示使用全局班次配置
     */
    @JsonProperty("class_setting_id")
    private Long classSettingId;
    /**
     * 打卡时间
     */
    @JsonProperty("plan_check_time")
    private LocalDateTime planCheckTime;

    /**
     * 调整后的打卡时间
     */
    @JsonProperty("changed_check_time")
    private LocalDateTime changedCheckTime;
    /**
     * 考勤组id
     */
    @JsonProperty("group_id")
    private Long groupId;

}
