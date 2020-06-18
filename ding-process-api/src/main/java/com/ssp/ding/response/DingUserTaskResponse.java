package com.ssp.ding.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.FormItem;
import lombok.Data;

import java.util.List;

/**
 * 用户待办
 *
 * @author: sunshaoping
 * @date: Create by in 3:58 下午 2020/6/17
 */
@Data
public class DingUserTaskResponse {

    /**
     * 待办表单数据
     */
    @JsonProperty("form_item_vo")
    private List<FormItem> forms;
    /**
     * 待办实例id
     */
    @JsonProperty("instance_id")
    private String instanceId;

    /**
     * 待办任务id
     */
    @JsonProperty("task_id")
    private String taskId;
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
