package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.DingWorkRecordService;
import com.ssp.ding.FormItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TODO 记得写注释
 *
 * @author: sunshaoping
 * @date: Create by in 1:19 下午 2020/6/18
 */
@Data
public class DingWorkRecordResponse {

    /**
     * 待办事项发起时间
     */
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    /**
     * 待办表单列表
     */
    @JsonProperty("forms")
    private List<FormItem> forms;
    /**
     * 待办事项id，可用此id调用{@link DingWorkRecordService#update(String, String) 更新待办}的接口
     */
    @JsonProperty("record_id")
    private String recordId;
    /**
     * 待办标题
     */
    @JsonProperty("title")
    private String title;
    /**
     * 待办跳转链接
     */
    @JsonProperty("url")
    private String url;

}
