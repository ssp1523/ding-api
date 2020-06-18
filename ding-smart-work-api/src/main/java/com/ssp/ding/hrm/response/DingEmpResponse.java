package com.ssp.ding.hrm.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 员工花名册信息结果
 *
 * @author: sunshaoping
 * @date: Create by in 1:48 下午 2020/6/18
 */
public class DingEmpResponse {
    /**
     * 花名册字段列表
     */
    @JsonProperty("field_list")
    private List<EmpFieldResponse> fieldList;
    /**
     * 是否是合作伙伴
     */
    @JsonProperty("partner")
    private Boolean partner;
    /**
     * 用户在企业的唯一标识
     */
    @JsonProperty("userid")
    private String userId;


}
