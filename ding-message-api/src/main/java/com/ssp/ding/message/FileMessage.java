package com.ssp.ding.message;

import com.ssp.ding.DingMediaService;
import com.ssp.ding.enumeration.MsgType;
import lombok.Builder;
import lombok.Getter;

/**
 * 图片消息
 *
 * @author: sunshaoping
 * @date: Create by in 7:40 下午 2020/6/15
 */
@Getter
public class FileMessage extends MediaMessage {

    /**
     * @param mediaId 媒体文件id。引用的媒体文件最大10MB。可以通过{@link DingMediaService 媒体文件上传}获取。
     */
    @Builder
    public FileMessage(String mediaId) {
        super(mediaId);
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.FILE;
    }
}
