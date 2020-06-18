package com.ssp.ding.hrm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 员工离职信息
 *
 * @author: sunshaoping
 * @date: Create by in 2:29 下午 2020/6/18
 */
@Data
public class DingEmployeeDimissionResponse {
    /**
     * 部门列表
     */
    @JsonProperty("dept_list")
    private List<EmpDept> deptList;
    /**
     * 离职交接人
     */
    @JsonProperty("handover_userid")
    private String handoverUserid;
    /**
     * 最后工作时间
     */
    @JsonProperty("last_work_day")
    private Long lastWorkDay;
    /**
     * 离职前主部门id
     */
    @JsonProperty("main_dept_id")
    private Long mainDeptId;
    /**
     * 离职前主部门名称
     */
    @JsonProperty("main_dept_name")
    private String mainDeptName;
    /**
     * 离职前工作状态：1:待入职；2:试用期；3:正式
     */
    @JsonProperty("pre_status")
    private Integer preStatus;
    /**
     * 离职原因备注
     */
    @JsonProperty("reason_memo")
    private String reasonMemo;
    /**
     * 离职原因类型：1:家庭原因；2:个人原因；3:发展原因；4:合同到期不续签；5:协议解除；6:无法胜任工作；7:经济性裁员；8:严重违法违纪；9:其他
     */
    @JsonProperty("reason_type")
    private Integer reasonType;
    /**
     * 离职状态：1:待离职；2:已离职
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 员工唯一标识ID
     */
    @JsonProperty("userid")
    private String userid;
}
