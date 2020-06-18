package com.ssp.ding.hrm.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * 扩展信息
 * @author: sunshaoping
 * @date: Create by in 3:03 下午 2020/6/18
 */
@NoArgsConstructor
@Data
public class DingExtendInfo {

    /**
     * 部门id
     */
    private List<Long> depts;
    /**
     * 员工类型枚举值（0:无类型；1:全职；2:兼职；3:实习；4:劳务派遣；5:退休返聘；6:劳务外包）
     */
    private Integer employeeType;
    /**
     * 主部门id
     */
    private Integer mainDeptId;
    /**
     * 主部门名称
     */
    private String mainDeptName;
    /**
     * 职位
     */
    private String position;
    /**
     * 工作地点
     */
    private String workPlace;
    /**
     * 工号
     */
    private String jobNumber;
}
