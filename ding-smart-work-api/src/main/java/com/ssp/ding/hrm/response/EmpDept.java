package com.ssp.ding.hrm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 部门
 *
 * @author: sunshaoping
 * @date: Create by in 2:30 下午 2020/6/18
 */
@Data
public class EmpDept {

    /**
     * 部门路径
     */
    @JsonProperty("dept_id")
    private Long deptId;
    /**
     * 部门id
     */
    @JsonProperty("dept_path")
    private String deptPath;
}
