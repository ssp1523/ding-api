package com.ssp.ding.response;

import lombok.Data;

/**
 * 工作通知消息的发送进度
 *
 * @author: sunshaoping
 * @date: Create by in 11:32 上午 2020/6/16
 */
@Data
public class DingSendProgressResponse {

    /**
     * 取值 0-100，表示处理的百分比
     */
    private Integer progressInPercent;
    /**
     * 任务执行状态，0=未开始，1=处理中，2=处理完毕
     */
    private Integer status;
}
