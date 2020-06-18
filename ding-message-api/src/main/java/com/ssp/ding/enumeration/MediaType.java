package com.ssp.ding.enumeration;

import lombok.Getter;

/**
 * 媒体文件类型
 *
 * @author: sunshaoping
 * @date: Create by in 10:47 上午 2020/6/16
 */
@Getter
public enum MediaType {
    /**
     * 图片（image）
     * 图片:1MB，支持JPG格式
     */
    IMAGE("image"),
    /**
     * 语音（voice）
     * 语音：2MB，播放长度不超过60s，AMR格式
     */
    VOICE("voice"),
    /**
     * 普通文件（file）
     * 普通文件：10MB
     */
    FILE("file");
    private final String type;

    MediaType(String type) {this.type = type;}

}
