package com.ssp.ding.hrm.response;

import lombok.Data;

import java.util.List;

/**
 * 员工花名册信息结果
 *
 * @author: sunshaoping
 * @date: Create by in 1:58 下午 2020/6/18
 */
@Data
public class DingEmpFieldGroupResponse {
    /**
     * 字段组ID
     */
    private String groupId;
    /**
     * 是否支持明细
     */
    private Boolean hasDetail;

    private List<DingField> fieldList;

}
