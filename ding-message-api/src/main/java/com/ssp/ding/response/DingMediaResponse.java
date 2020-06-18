package com.ssp.ding.response;

import lombok.Data;

/**
 * 媒体响应信息
 *
 * @author: sunshaoping
 * @date: Create by in 10:35 上午 2020/6/16
 */
@Data
public class DingMediaResponse {


    /**
     * 媒体文件上传时间戳
     */
    private Long createdAt;
    /**
     * 媒体文件上传后获取的唯一标识；普通文件（file）：10MB
     */
    private String mediaId;
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、普通文件（file）。
     */
    private String type;
}
