package com.ssp.ding.hrm.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * 待入职
 *
 * @author: sunshaoping
 * @date: Create by in 3:01 下午 2020/6/18
 */
@Getter
@Builder
public class DingPreEntryEmployeeRequest {
    /**
     * 扩展信息
     */
    @JsonProperty("extend_info")
    private final DingExtendInfo extendInfo;
    /**
     * 手机号
     */
    @JsonProperty("mobile")
    private final String mobile;
    /**
     * 员工姓名
     */
    @JsonProperty("name")
    private final String name;
    /**
     * 操作人userid
     */
    @JsonProperty("op_userid")
    private final String opUserid;
    /**
     * 预期入职时间
     */
    @JsonProperty("pre_entry_time")
    private final Date preEntryTime;

}
