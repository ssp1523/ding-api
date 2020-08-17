package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 管理范围
 *
 * @author: sunshaoping
 * @date: Create by in 1:44 下午 2020/6/11
 */
@Data
@Builder
public class ManageScopeResponse {

    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 部门名称
     */
    private String name;
}
