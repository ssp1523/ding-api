package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 评论附件
 *
 * @author: sunshaoping
 * @date: Create by in 6:16 下午 2020/6/17
 */
public class Attachment {

    /**
     * 附件id
     */
    @JsonProperty("file_id")
    private String fileId;
    /**
     * 附件名称
     */
    @JsonProperty("file_name")
    private String fileName;
    /**
     * 附件大小
     */
    @JsonProperty("file_size")
    private String fileSize;
    /**
     * 附件类型
     */
    @JsonProperty("file_type")
    private String fileType;
}
