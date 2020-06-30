package com.ssp.ding.message.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.DingMediaService;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * OA消息体
 *
 * @author: sunshaoping
 * @date: Create by in 10:25 上午 2020/6/16
 */
@Builder
@Getter
public class OABody {
    /**
     * 消息体的标题，建议50个字符以内
     */
    @JsonProperty("title")
    private final String title;
    /**
     * 单行富文本信息
     */
    @JsonProperty("rich")
    private final OARich rich;
    /**
     * 消息体的内容，最多显示3行
     */
    @JsonProperty("content")
    private final String content;
    /**
     * 消息体中的图片，支持图片资源@mediaId {@link DingMediaService}
     */
    @JsonProperty("image")
    private final String image;
    /**
     * 自定义的附件数目。此数字仅供显示，钉钉不作验证
     */
    @JsonProperty("file_count")
    private final String fileCount;
    /**
     * 自定义的作者名字
     */
    @JsonProperty("author")
    private final String author;
    /**
     * 消息体的表单，最多显示6个，超过会被隐藏
     */
    @JsonProperty("form")
    private final List<OAForm> form;

}
