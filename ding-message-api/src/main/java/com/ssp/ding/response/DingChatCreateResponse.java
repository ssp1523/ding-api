package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 创建群响应信息
 *
 * @author: sunshaoping
 * @date: Create by in 6:14 下午 2020/6/15
 */
@Data
@Builder
public class DingChatCreateResponse {

    /**
     * 群会话的id
     */
    private String chatId;
    /**
     * 会话类型。2表示企业群
     */
    private Long conversationTag;

}
