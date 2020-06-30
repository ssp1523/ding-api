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
public class ImageMessage extends MediaMessage {

    /**
     * @param mediaId 媒体文件id。可以通过{@link DingMediaService 媒体文件上传}接口获取。建议宽600像素 x 400像素，宽高比3 : 2
     */
    @Builder
    public ImageMessage(String mediaId) {
        super(mediaId);
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.IMAGE;
    }
}
