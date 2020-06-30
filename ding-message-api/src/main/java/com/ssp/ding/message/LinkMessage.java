package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.DingMediaService;
import com.ssp.ding.enumeration.MsgType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 链接消息
 *
 * @author: sunshaoping
 * @date: Create by in 8:08 下午 2020/6/15
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Getter
public class LinkMessage extends DingMessage {


    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接
     */
    @JsonProperty("messageUrl")
    private final String messageUrl;
    /**
     * 图片地址。可以通过{@link DingMediaService 媒体文件上传}获取。
     */
    @JsonProperty("picUrl")
    private final String picUrl;
    /**
     * 消息标题，建议100字符以内
     */
    @JsonProperty("title")
    private final String title;
    /**
     * 消息描述，建议500字符以内
     */
    @JsonProperty("text")
    private final String text;

    @Override
    public MsgType getMsgType() {
        return MsgType.LINK;
    }


}
