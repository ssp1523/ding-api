package com.ssp.ding.response;

/**
 * 审批实例业务动作
 *
 * @author: sunshaoping
 * @date: Create by in 6:41 下午 2020/6/17
 */
public enum BizAction {

    /**
     * 表示该审批实例是基于原来的实例修改而来
     */
    MODIFY,
    /**
     * 表示该审批实例对原来的实例进行撤销
     */
    REVOKE,
    /**
     * 表示正常发起
     */
    NONE

}
