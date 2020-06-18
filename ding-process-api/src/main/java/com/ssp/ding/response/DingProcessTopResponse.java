package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 审批模板
 *
 * @author: sunshaoping
 * @date: Create by in 5:06 下午 2020/6/17
 */
@Data
public class DingProcessTopResponse {
    /**
     * 图标url
     */
    @JsonProperty("icon_url")
    private String iconUrl;
    /**
     * 审批模板名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 模板唯一标识
     */
    @JsonProperty("process_code")
    private String processCode;
    /**
     * 模板跳转url
     */
    @JsonProperty("url")
    private String url;
}
