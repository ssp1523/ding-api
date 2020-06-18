package com.ssp.ding.response;

import lombok.Data;

/**
 * 部门响应数据
 *
 * @author: sunshaoping
 * @date: Create by in 1:22 下午 2020/6/8
 */
@Data
public class DingDepartmentResponse {


    /**
     * 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     */
    private Boolean autoAddUser;
    /**
     * 是否创建一个关联此部门的企业群，默认为false
     */
    private Boolean createDeptGroup;
    /**
     * 部门id
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id，根部门id为1
     */
    private Long parentId;

}
