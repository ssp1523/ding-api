package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 实例查询条件
 *
 * @author: sunshaoping
 * @date: Create by in 5:52 下午 2020/6/17
 */
@Getter
@Builder
public class DingProcessInstanceListIdsRequest {


    private final String processCode;
    /**
     * 开始时间
     */
    private final LocalDateTime startTime;
    /**
     * 结束时间。不传该参数则默认取当前时间
     */
    @Nullable
    private final LocalDateTime endTime;
    /**
     * 发起人用户id列表，用逗号分隔，最大列表长度：10
     */
    private final List<String> userIdList;

}
