package com.ssp.ding.request;

import java.util.List;

/**
 * @author: sunshaoping
 * @date: Create by in 6:16 下午 2020/6/15
 */
public class DingChatUpdateRequest extends DingChatCreateRequest {
    /**
     * 添加成员列表，每次最多支持40人，群人数上限为1000
     */
    private List<String> addUserIdList;
    /**
     * 删除成员列表，每次最多支持40人，群人数上限为1000
     */
    private List<String> delUserIdList;
    /**
     * 群头像mediaid
     */
    private String icon;

    public DingChatUpdateRequest(String name, String owner, List<String> userIdList) {
        super(name, owner, userIdList);
    }
}
