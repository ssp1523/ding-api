package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 钉钉回调失败数据
 *
 * @author: sunshaoping
 * @date: Create by in 3:23 下午 2020/6/19
 */
@Data
@Builder
public class DingCallBackFailedResponse {
    /**
     * bpms_instance_change
     */
    @JsonProperty("bpms_instance_change")
    private String bpmsInstanceChange;
    /**
     * bpms_task_change
     */
    @JsonProperty("bpms_task_change")
    private String bpmsTaskChange;
    /**
     * 事件类型，有20种，
     * “user_add_org”, “user_modify_org”, “user_leave_org”,“org_admin_add”, “org_admin_remove”, “org_dept_create”, “org_dept_modify”, “org_dept_remove”, “org_remove”, “chat_add_member”, “chat_remove_member”, “chat_quit”, “chat_update_owner”, “chat_update_title”, “chat_disband”,“chat_disband_microapp”, “check_in”,“bpms_task_change”,“bpms_instance_change”,“label_user_change”, “label_conf_add”, “label_conf_modify”,“label_conf_del”
     */
    @JsonProperty("call_back_tag")
    private String callBackTag;
    /**
     * check_in
     */
    @JsonProperty("check_in")
    private String checkIn;
    /**
     * data
     */
    @JsonProperty("data")
    private String data;
    /**
     * event_time
     */
    @JsonProperty("event_time")
    private Long eventTime;
    /**
     * org_admin_add
     */
    @JsonProperty("org_admin_add")
    private String orgAdminAdd;
    /**
     * org_admin_remove
     */
    @JsonProperty("org_admin_remove")
    private String orgAdminRemove;
    /**
     * org_change
     */
    @JsonProperty("org_change")
    private String orgChange;
    /**
     * org_dept_create
     */
    @JsonProperty("org_dept_create")
    private String orgDeptCreate;
    /**
     * org_dept_modify
     */
    @JsonProperty("org_dept_modify")
    private String orgDeptModify;
    /**
     * org_dept_remove
     */
    @JsonProperty("org_dept_remove")
    private String orgDeptRemove;
    /**
     * user_add_org
     */
    @JsonProperty("user_add_org")
    private String userAddOrg;
    /**
     * user_leave_org
     */
    @JsonProperty("user_leave_org")
    private String userLeaveOrg;
    /**
     * user_modify_org
     */
    @JsonProperty("user_modify_org")
    private String userModifyOrg;


}
