package com.ssp.ding.hrm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 花名册字段
 *
 * @author: sunshaoping
 * @date: Create by in 1:53 下午 2020/6/18
 */
@Data
public class EmpFieldResponse {
    /**
     * 字段编码
     */
    @JsonProperty("field_code")
    private String fieldCode;
    /**
     * 字段业务名称
     */
    @JsonProperty("field_name")
    private String fieldName;
    /**
     * 字段分组id
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * 对应value的文本值（当value为枚举值时，label取值为value的文本翻译；否则，label取值同value。详见结果示例
     */
    @JsonProperty("label")
    private String label;
    /**
     * 字段的值（详见结果示例）
     */
    @JsonProperty("value")
    private String value;
}
