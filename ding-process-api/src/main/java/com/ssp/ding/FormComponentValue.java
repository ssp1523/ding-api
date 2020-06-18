package com.ssp.ding;

import lombok.Builder;
import lombok.Getter;

/**
 * 表单参数
 *
 * @author: sunshaoping
 * @date: Create by in 2:45 下午 2020/6/17
 */
@Getter
@Builder
public class FormComponentValue {

    /**
     * 扩展值
     */
    private final String extValue;
    /**
     * 表单每一栏的名称，对应表单组件的label字段
     */
    private final String name;
    /**
     * 表单每一栏的值
     */
    private final String value;
}
