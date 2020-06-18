package com.ssp.ding;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 待办表单数据
 *
 * @author: sunshaoping
 * @date: Create by in 3:59 下午 2020/6/17
 */
@Data
public class FormItem {

    /**
     * 待办内容
     */
    @JsonProperty("content")
    private String content;

    /**
     * 待办标题
     */
    @JsonProperty("title")
    private String title;
}
