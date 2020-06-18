package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 工作通知消息
 *
 * @author: sunshaoping
 * @date: Create by in 2:14 下午 2020/6/16
 */
@Getter
@Builder
public class DingCorpConversationRequest {
    /**
     * 企业内部应用是应用agentId，第三方企业应用是获取授权信息接口中返回的agentId
     */
    private final Long agentId;
    /**
     * 接收者的部门id列表，最大列表长度：20,  接收者是部门id下(包括子部门下)的所有用户
     */
    private final List<Long> deptIdList;
    /**
     * 接收者的用户userid列表，最大用户列表长度：100
     */
    private final List<String> userIdList;
    /**
     * 是否发送给企业全部用户(ISV不能设置true)
     */
    private final Boolean toAllUser;

}
