package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送被禁止的具体原因
 *
 * @author: sunshaoping
 * @date: Create by in 2:28 下午 2020/6/30
 */
public class SendForbiddenModel {
    /**
     * 流控code。包括以下code：
     * <p>
     * 143105表示企业自建应用每日推送给用户的消息超过上限
     * <p>
     * 143106表示企业自建应用推送给用户的消息重复
     */
    @JsonProperty("code")
    private String code;
    /**
     * 流控阀值
     */
    @JsonProperty("count")
    private Long count;
    /**
     * 被流控员工userId
     */
    @JsonProperty("userid")
    private String userId;
}
