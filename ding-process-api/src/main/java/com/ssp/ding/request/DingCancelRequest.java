package com.ssp.ding.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 取消待办
 *
 * @author: sunshaoping
 * @date: Create by in 3:52 下午 2020/6/17
 */
@Getter
@Builder
public class DingCancelRequest {

    /**
     * 企业应用标识
     */
    @JsonProperty("agentid")
    private final Long agentId;
    /**
     * 待办组id，需要在调用创建待办接口时，主动设置该值
     */
    @JsonProperty("activity_id")
    private final String activityId;
    /**
     * 待办组id列表，用于批量取消
     */
    @JsonProperty("string")
    private final List<String> activityIdList;
    /**
     * 实例id，通过创建待办实例接口获取
     */
    @JsonProperty("process_instance_id")
    private final String processInstanceId;

}
