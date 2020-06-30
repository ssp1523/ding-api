package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 发送结果
 *
 * @author: sunshaoping
 * @date: Create by in 11:32 上午 2020/6/16
 */
@Data
public class DingSendResultResponse {
    /**
     * 发送失败的用户id
     */
    @JsonProperty("failed_user_id_list")
    private List<String> failedUserIdList;
    /**
     * 推送被禁止的具体原因列表
     */
    @JsonProperty("forbidden_list")
    private List<SendForbiddenModel> forbiddenList;
    /**
     * 因发送消息超过上限而被流控过滤后实际未发送的userid。未被限流的接收者仍会被收到消息。限流规则包括：
     * <p>
     * 1.同一个微应用相同消息的内容同一个用户一天只能接收一次
     * 2.同一个微应用给同一个用户发送消息，
     * <p>
     * 如果是第三方企业应用，一天最多为50次；
     * <p>
     * 如果是企业内部开发方式，一天最多为500次
     */
    @JsonProperty("forbidden_user_id_list")
    private List<String> forbiddenUserIdList;
    /**
     * 无效的部门id
     */
    @JsonProperty("invalid_dept_id_list")
    private List<Long> invalidDeptIdList;
    /**
     * 无效的用户id
     */
    @JsonProperty("invalid_user_id_list")
    private List<String> invalidUserIdList;
    /**
     * 已读消息的用户id
     */
    @JsonProperty("read_user_id_list")
    private List<String> readUserIdList;
    /**
     * 未读消息的用户id
     */
    @JsonProperty("unread_user_id_list")
    private List<String> unreadUserIdList;


}
