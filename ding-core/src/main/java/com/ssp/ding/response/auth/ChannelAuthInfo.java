package com.ssp.ding.response.auth;

import lombok.Data;

import java.util.List;

/**
 * 授权的服务窗应用信息列表
 *
 * @author: sunshaoping
 * @date: Create by in 2:41 下午 2020/6/7
 */
@Data
public class ChannelAuthInfo {

    /**
     * 应用信息列表
     */
    private List<ChannelAgent> channelAgents;
}
