package com.ssp.ding.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.api.DingMediaService;
import com.ssp.ding.enumeration.MsgType;
import lombok.Builder;
import lombok.Getter;

import java.time.Duration;

/**
 * 语音消息
 *
 * @author: sunshaoping
 * @date: Create by in 7:40 下午 2020/6/15
 */
@Getter
public class VoiceMessage extends MediaMessage {

    /**
     * 正整数，小于60，表示音频时长
     */
    @JsonProperty("duration")
    private final Duration duration;

    /**
     * @param mediaId  媒体文件id。2MB，播放长度不超过60s，AMR格式。
     *                 可以通过{@link DingMediaService 媒体文件上传}接口获取。
     * @param duration 正整数，小于60，表示音频时长
     */
    @Builder
    public VoiceMessage(String mediaId, Duration duration) {
        super(mediaId);
        this.duration = duration;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.VOICE;
    }
}
