package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

/**
 * 表单属性
 *
 * @author: sunshaoping
 * @date: Create by in 1:15 下午 2020/6/17
 */
@Getter
@Builder
public class FormComponentProp {

    /**
     * 表单组件id，必须在模板里唯一。
     * 包含两段字符串：
     * 第一段为表单的component_name；
     * 第二段为8位随机字符串
     * 例子:TextField-J78F056R
     */
    private final String id;
    /**
     * 表单组件名称
     */
    private final String label;
    /**
     * 是否必填
     */
    private final Boolean required;
    /**
     * 单位
     */
    private final String unit;
    /**
     * 是否禁用大写
     */
    private final String notUpper;
    /**
     * 输入框提示,如:请输入 , 请选择
     */
    private final String placeholder;

}
