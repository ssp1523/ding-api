package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 成员排班信息查询条件
 *
 * @author: sunshaoping
 * @date: Create by in 2:24 下午 2020/6/19
 */
@Getter
@Builder
public class DingScheduleUserRequest {

    /**
     * 起始日期
     */
    private final LocalDateTime fromDateTime;
    /**
     * 结束日期
     */
    private final LocalDateTime toDateTime;
    /**
     * 操作人userId
     */
    private final String opUserId;

    /**
     * 用户userId列表
     */
    private final List<String> userIds;
}
