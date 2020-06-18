package com.ssp.ding.message.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OA单行富文本信息
 *
 * @author: sunshaoping
 * @date: Create by in 10:25 上午 2020/6/16
 */
@NoArgsConstructor
@Data
public class OARich {
    /**
     * 单行富文本信息的数目
     */
    @JsonProperty("num")
    private String num;
    /**
     * 单行富文本信息的单位
     */
    @JsonProperty("unit")
    private String unit;
}
