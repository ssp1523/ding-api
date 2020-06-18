package com.ssp.ding.response;

import lombok.Builder;
import lombok.Getter;

/**
 * 授权应用信息
 *
 * @author: sunshaoping
 * @date: Create by in 2:59 下午 2020/6/7
 */

@Getter
@Builder
public class AgentResponse  {

    /**
     * 授权方企业应用id
     */
    private final Long agentId;
    /**
     * 授权方企业应用是否被禁用（0:禁用 1:正常 2:待激活 ）
     */
    private final Long close;
    /**
     * 授权方企业应用详情
     */
    private final String description;
    /**
     * 授权方企业应用头像
     */
    private final String logoUrl;
    /**
     * 授权方企业应用名称
     */
    private final String name;


}
