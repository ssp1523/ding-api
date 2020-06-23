package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 某个工作日的排班信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:27 下午 2020/6/18
 */
@Data
public class DingScheduleDayResponse {
    /**
     * 排班绑定的假勤审批类型
     * <p>
     * 1：加班，2：出差，3：请假
     */
    @JsonProperty("approve_biz_type")
    private Integer approveBizType;
    /**
     * 排班绑定的审批单id
     */
    @JsonProperty("approve_id")
    private Long approveId;
    /**
     * 排班绑定的假勤审批单名称
     */
    @JsonProperty("approve_tag_name")
    private String approveTagName;
    /**
     *
     */
    @JsonProperty("approve_type")
    private String approveType;
    /**
     * 允许迟到早退等规则调整后的计划打卡时间
     */
    @JsonProperty("base_check_time")
    private LocalDateTime baseCheckTime;
    /**
     * 开始打卡时间
     */
    @JsonProperty("check_begin_time")
    private LocalDateTime checkBeginTime;
    /**
     * 打卡时间
     */
    @JsonProperty("check_date_time")
    private LocalDateTime checkDateTime;
    /**
     * 结束打卡时间
     */
    @JsonProperty("check_end_time")
    private LocalDateTime checkEndTime;
    /**
     * 卡点状态
     * <p>
     * Init：未打卡
     * <p>
     * Checked：已打卡
     * <p>
     * Timeout：缺卡
     */
    @JsonProperty("check_status")
    private String checkStatus;
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
     * 考勤班次id
     */
    @JsonProperty("class_id")
    private Long classId;
    /**
     * 班次名称
     */
    @JsonProperty("class_name")
    private String className;
    /**
     * 排班关联的班次设置id
     */
    @JsonProperty("class_setting_id")
    private Long classSettingId;
    /**
     * 企业id
     */
    @JsonProperty("corp_id")
    private String corpId;
    /**
     * 扩展字段
     */
    @JsonProperty("features")
    private String features;
    /**
     * 创建时间
     */
    @JsonProperty("gmt_create")
    private LocalDateTime gmtCreate;
    /**
     * 最后更新时间
     */
    @JsonProperty("gmt_modified")
    private LocalDateTime gmtModified;
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
     * 员工id
     */
    @JsonProperty("user_id")
    private String userId;
    /**
     * 工作日，代表具体哪一天的排班
     */
    @JsonProperty("work_date")
    private LocalDate workDate;

}
