package com.ssp.ding.response.auth;

import com.taobao.api.internal.mapping.ApiField;
import lombok.Data;

import java.util.List;

/**
 * 授权的应用信息
 *
 * @author: sunshaoping
 * @date: Create by in 2:48 下午 2020/6/7
 */
@Data
public class Agent {

    private List<String> adminList;
    private String agentName;
    private Long agentId;
    private Long appId;
    private String logoUrl;
}
