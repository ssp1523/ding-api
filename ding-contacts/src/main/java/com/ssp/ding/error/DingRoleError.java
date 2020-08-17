package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 角色错误
 *
 * @author: sunshaoping
 * @date: Create by in 10:28 上午 2020/8/17
 */

@Getter
@RequiredArgsConstructor
public enum DingRoleError implements DingInternalError {

    ROLE_NOT_FOUND("ROLE0001", "角色没找到 role={0,number,#}");

    private final String errCode;

    private final String errMsg;

}
