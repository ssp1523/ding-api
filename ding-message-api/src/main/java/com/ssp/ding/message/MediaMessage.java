package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * 媒体消息
 *
 * @author: sunshaoping
 * @date: Create by in 7:40 下午 2020/6/15
 */
@Getter
public abstract class MediaMessage extends DingMessage {

    @JsonProperty("media_id")
    private final String mediaId;

    protected MediaMessage(String mediaId) {
        this.mediaId = mediaId;
    }

}
