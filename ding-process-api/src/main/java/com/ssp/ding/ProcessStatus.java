package com.ssp.ding;

/**
 * 工作流状态
 * 状态说明:https://ding-doc.dingtalk.com/doc#/serverapi2/as4xlh/Nj30S
 *
 * @author: sunshaoping
 * @date: Create by in 3:11 下午 2020/6/17
 */
public enum ProcessStatus {
    /**
     * 新创建
     */
    NEW,
    /**
     * 运行中
     */
    RUNNING,

    /**
     * 完成
     */
    COMPLETED,
    /**
     * 取消
     */
    CANCELED,

    /**
     * 被终止
     */
    TERMINATED
}
