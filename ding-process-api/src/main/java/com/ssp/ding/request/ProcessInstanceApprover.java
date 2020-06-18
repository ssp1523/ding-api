package com.ssp.ding.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 审批人
 *
 * @author: sunshaoping
 * @date: Create by in 5:26 下午 2020/6/17
 */
@Getter
@Builder
public class ProcessInstanceApprover {

    /**
     * 审批类型。
     * <p>
     * AND表示会签，
     * <p>
     * OR表示或签，
     * <p>
     * NONE表示单人
     */
    @JsonProperty("task_action_type")
    private final TaskActionType taskActionType;
    /**
     * 审批人userid列表。
     * <p>
     * 会签/或签列表长度必须大于1，非会签/或签列表长度只能为1
     */
    @JsonProperty("user_ids")
    private final List<String> userIds;

}
