package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * 标签组
 *
 * @author: sunshaoping
 * @date: Create by in 7:47 下午 2020/6/10
 */
@Data
public class LabelGroupResponse {

    /**
     * 标签组颜色
     */
    private Integer color;
    /**
     * 标签组名字
     */
    private String name;
    /**
     * 标签列表
     */
    private List<LabelResponse> labels;


}
