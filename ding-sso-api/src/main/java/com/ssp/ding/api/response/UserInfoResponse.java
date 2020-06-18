package com.ssp.ding.api.response;

import lombok.Data;

/**
 * 用户信息
 *
 * @author: sunshaoping
 * @date: Create by in 5:32 下午 2020/6/15
 */
@Data
public class UserInfoResponse {
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * email地址
     */
    private String email;
    /**
     * 用户名字
     */
    private String name;

    /**
     * 员工在企业内的唯一id
     */
    private String userid;


}
