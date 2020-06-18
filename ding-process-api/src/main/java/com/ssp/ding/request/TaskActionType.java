package com.ssp.ding.request;

/**
 * 审批类型。
 * <p>
 * AND表示会签，
 * <p>
 * OR表示或签，
 * <p>
 * NONE表示单人
 *
 * @author: sunshaoping
 * @date: Create by in 5:26 下午 2020/6/17
 */
public enum TaskActionType {
    /**
     * 会签
     */
    AND,
    /**
     * 或签
     */
    OR,
    /**
     * 单人
     */
    NONE,
}
