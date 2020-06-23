package com.ssp.ding.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 操作记录
 *
 * @author: sunshaoping
 * @date: Create by in 6:03 下午 2020/6/17
 */
public class OperationRecord {
    /**
     *
     */
    @JsonProperty("attachment")
    private List<Attachment> attachments;

    @JsonProperty("date")
    private LocalDateTime date;

    /**
     * 操作结果
     * <p>
     * 分为NONE（无）, AGREE（同意），REFUSE（拒绝）
     */
    @JsonProperty("operation_result")
    private OperationResult operationResult;

    @JsonProperty("operation_type")
    private String operationType;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("userid")
    private String userId;
}
