package com.ssp.ding.hrm.request;

import lombok.Builder;
import lombok.Getter;

/**
 * 花名册字段信息
 *
 * @author: sunshaoping
 * @date: Create by in 1:42 下午 2020/6/18
 */
@Builder
@Getter
public class EmpField {
    /**
     * 更新的字段值
     */
    private final String value;
    /**
     * 更新的字段code
     */
    private final String fieldCode;
}
