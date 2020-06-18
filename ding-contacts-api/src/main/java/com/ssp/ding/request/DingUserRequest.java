package com.ssp.ding.request;

import lombok.Data;

/**
 * 钉钉用户请求数据
 *
 * @author: sunshaoping
 * @date: Create by in 1:35 下午 2020/6/8
 */
@Data
public class DingUserRequest  {

    private String mobile;

    private String stateCode;
}
