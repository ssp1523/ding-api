package com.ssp.ding.request;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * 创建会话(群)
 *
 * @author: sunshaoping
 * @date: Create by in 6:08 下午 2020/6/15
 */
@Data
public class DingChatCreateRequest {

    /**
     * 群禁言，0-默认，不禁言，1-全员禁言
     */
    private Integer chatBannedType;
    /**
     * 管理类型，0-默认，所有人可管理，1-仅群主可管理
     */
    private Integer managementType;
    /**
     * @ all 权限，0-默认，所有人，1-仅群主可@ all
     */
    private Integer mentionAllAuthority;
    /**
     * 群名称，长度限制为1~20个字符
     */
    @NonNull
    private String name;
    /**
     * 群主userId，员工唯一标识ID；必须为该会话{@link #userIdList}的成员之一
     */
    @NonNull
    private String owner;

    /**
     * 群可搜索，0-默认，不可搜索，1-可搜索
     */
    private Integer searchable;
    /**
     * 新成员是否可查看聊天历史消息（新成员入群是否可查看最近100条聊天记录）
     * 0代表否；1代表是；不传默认为否
     */
    private Integer showHistoryType;
    /**
     * 群成员列表，每次最多支持40人，群人数上限为1000
     */
    @NonNull
    private List<String> userIdList;
    /**
     * 入群验证，0：不入群验证（默认） 1：入群验证
     */
    private Integer validationType;


}
