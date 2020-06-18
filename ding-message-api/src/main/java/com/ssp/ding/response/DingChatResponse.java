package com.ssp.ding.response;

import lombok.Data;

import java.util.List;

/**
 * 会话
 *
 * @author: sunshaoping
 * @date: Create by in 6:26 下午 2020/6/15
 */
@Data
public class DingChatResponse {

    /**
     * 群禁言，0-默认，不禁言，1-全员禁言
     */
    private Integer chatBannedType;
    /**
     * 会话类型。2表示企业群
     */
    private Integer conversationTag;

    /**
     * 群头像mediaId
     */
    private String icon;
    /**
     * 仅群主和群管理员可管理 0否 1 是
     */
    private Integer managementType;
    /**
     * 仅群主和管理员可@所有人 0 否 1 是
     */
    private Integer mentionAllAuthority;
    /**
     * 群名称
     */
    private String name;
    /**
     * 群主userid
     */
    private String owner;
    /**
     * 是否可以搜索群名 0 不可以 1可以搜索
     */
    private Integer searchable;
    /**
     * 新成员可查看聊天历史 0否 1是
     */
    private Integer showHistoryType;
    /**
     * 群成员userId列表
     */
    private List<String> userIdList;
    /**
     * 入群需群主或群管理员同意 0不需要 1需要
     */
    private Integer validationType;

}
