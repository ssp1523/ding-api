package com.ssp.ding.response.auth;

import lombok.Data;

/**
 * 应用信息列表
 *
 * @author: sunshaoping
 * @date: Create by in 2:53 下午 2020/6/7
 */
@Data
public class ChannelAgent {

    private String agentName;
    private Long agentId;
    private Long appId;
    private String logoUrl;
}
