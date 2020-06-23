package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO 记得写注释
 *
 * @author: sunshaoping
 * @date: Create by in 3:23 下午 2020/6/19
 */
public class DingCallBackFailedResponse {

    @JsonProperty("bpms_instance_change")
    private String bpmsInstanceChange;
    @JsonProperty("bpms_task_change")
    private String bpmsTaskChange;
    @JsonProperty("call_back_tag")
    private String callBackTag;
    @JsonProperty("check_in")
    private String checkIn;
    @JsonProperty("data")
    private String data;
    @JsonProperty("event_time")
    private Long eventTime;
    @JsonProperty("org_admin_add")
    private String orgAdminAdd;
    @JsonProperty("org_admin_remove")
    private String orgAdminRemove;
    @JsonProperty("org_change")
    private String orgChange;
    @JsonProperty("org_dept_create")
    private String orgDeptCreate;
    @JsonProperty("org_dept_modify")
    private String orgDeptModify;
    @JsonProperty("org_dept_remove")
    private String orgDeptRemove;
    @JsonProperty("user_add_org")
    private String userAddOrg;
    @JsonProperty("user_leave_org")
    private String userLeaveOrg;
    @JsonProperty("user_modify_org")
    private String userModifyOrg;

}
