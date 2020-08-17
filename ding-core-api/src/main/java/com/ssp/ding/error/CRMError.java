package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * CRM错误
 *
 * @author: sunshaoping
 * @date: Create by in 11:16 上午 2020/8/13
 */
@Getter
@RequiredArgsConstructor
public enum CRMError implements DingError {
    /**
     * 无
     */
    CONFIG_CREATE_FAIL("60125", "CRM配置信息创建失败"),
    /**
     * 无
     */
    CONFIG_UPDATE_FAIL("60126", "CRM配置信息更新失败"),
    /**
     * 无
     */
    CONFIG_DELETE_FAIL("60127", "CRM人员配置信息删除失败"),

    ;
    private final String errCode;

    private final String errMsg;

}
