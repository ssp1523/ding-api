package com.ssp.ding.request;

import com.ssp.ding.DingProcessService;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 工作流实例
 *
 * @author: sunshaoping
 * @date: Create by in 2:41 下午 2020/6/17
 */
@Getter
@Builder
public class ProcessInstanceRequest {
    /**
     * 企业应用标识
     */
    @Nullable
    private final Long agentId;
    /**
     * 实例的标题
     */
    @Nullable
    private final String title;
    /**
     * 实例在审批应用里的跳转url，需要同时适配移动端和pc端
     */
    private final String url;
    /**
     * 表单参数
     */
    private final List<FormComponentValue> formComponentValues;
    /**
     * 实例发起人的userid
     */
    private final String originatorUserId;
    /**
     * 模板唯一码，通过{@link DingProcessService#create(DingSaveProcessRequest) 创建模板接口}
     * 或{@link DingProcessService#getByName(String) 获取模板code接口}  获取
     */
    private final String processCode;

}
