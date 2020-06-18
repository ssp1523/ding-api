package com.ssp.ding.message.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * OA消息头部内容
 *
 * @author: sunshaoping
 * @date: Create by in 10:25 上午 2020/6/16
 */
@Builder
@Getter
public class OAHead {
    /**
     * 消息头部的背景颜色。长度限制为8个英文字符，其中前2为表示透明度，后6位表示颜色值。不要添加0x
     */
    @JsonProperty("bgcolor")
    private final String bgColor;
    /**
     * 消息的头部标题 (向普通会话发送时有效，向企业会话发送时会被替换为微应用的名字)，长度限制为最多10个字符
     */
    @JsonProperty("text")
    private final String text;
}
