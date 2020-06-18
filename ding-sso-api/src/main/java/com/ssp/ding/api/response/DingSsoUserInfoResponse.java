package com.ssp.ding.api.response;

import lombok.Data;

/**
 * 应用管理员的身份信息
 *
 * @author: sunshaoping
 * @date: Create by in 5:29 下午 2020/6/15
 */
@Data
public class DingSsoUserInfoResponse {

    /**
     * 是否是管理员（在这里是true）
     */
    private Boolean isSys;

    private CorpInfoResponse corpInfo;

    private UserInfoResponse userInfo;


}
