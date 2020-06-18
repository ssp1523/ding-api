package com.ssp.ding.response.auth;

import lombok.Data;

import java.util.List;

/**
 * 授权信息
 *
 * @author: sunshaoping
 * @date: Create by in 2:40 下午 2020/6/7
 */
@Data
public class AuthInfo {

    private List<Agent> agents;

}
