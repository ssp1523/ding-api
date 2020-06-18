package com.ssp.ding.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author: sunshaoping
 * @date: Create by in 6:53 下午 2020/6/17
 */
@Getter
@Builder
public class GrantCspaceRequest {
    /**
     * 应用id
     */
    @JsonProperty("agentid")
    private final Long agentId;
    /**
     * 审批附件id
     */
    @JsonProperty("file_id")
    private final String fileId;
    /**
     * 附件id列表，支持批量授权
     */
    @JsonProperty("fileid_list")
    private final List<String> fileIdList;
    /**
     * 实例id
     */
    @JsonProperty("process_instance_id")
    private final String processInstanceId;
    /**
     * 授权允许预览附件的用户id
     */
    @JsonProperty("userid")
    private final String userId;
}
