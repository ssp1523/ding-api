package com.ssp.ding.message.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OA消息体的表单
 *
 * @author: sunshaoping
 * @date: Create by in 10:26 上午 2020/6/16
 */
@NoArgsConstructor
@Data
public class OAForm {
    /**
     * 消息体的关键字
     */
    @JsonProperty("key")
    private String key;
    /**
     * 消息体的关键字对应的值
     */
    @JsonProperty("value")
    private String value;
}
