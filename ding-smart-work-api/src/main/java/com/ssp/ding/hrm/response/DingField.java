package com.ssp.ding.hrm.response;

import lombok.Data;

/**
 * 花名册字段
 *
 * @author: sunshaoping
 * @date: Create by in 2:13 下午 2020/6/18
 */
@Data
public class DingField {

    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 字段业务名称
     */
    private String fieldName;
    /**
     * 字段编码
     */
    private String fieldCode;
}
