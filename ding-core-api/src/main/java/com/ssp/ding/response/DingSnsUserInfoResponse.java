package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 用户信息
 *
 * @author: sunshaoping
 * @date: Create by in 4:57 下午 2020/6/15
 */
@Data
@Builder
public class DingSnsUserInfoResponse {

    /**
     * 用户在钉钉上面的昵称
     */
    private String nick;
    /**
     * 用户在当前开放应用内的唯一标识
     */
    private String openId;
    /**
     * 用户在当前开放应用所属企业的唯一标识
     */
    private String unionId;
}
