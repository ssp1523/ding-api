package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 表单
 *
 * @author: sunshaoping
 * @date: Create by in 1:12 下午 2020/6/17
 */
@Getter
@Builder
public class FormComponent {

    /**
     * 组件类型。参数值只支持本文中列出的“支持的表单组件”列出的component_name，不支持其他值
     */
    private final String componentName;

    /**
     * 表单属性
     */
    private final List<FormComponentProp> props;

}
