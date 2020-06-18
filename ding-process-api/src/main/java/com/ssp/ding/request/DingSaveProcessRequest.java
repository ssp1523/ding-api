package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 创建或更新
 *
 * @author: sunshaoping
 * @date: Create by in 11:33 上午 2020/6/17
 */
@Getter
@Builder
public class DingSaveProcessRequest {
    /**
     * 企业微应用标识
     */
    private final Long agentId;
    /**
     * 模板描述
     */
    private final String description;

    private final Boolean disableFormEdit;

    /**
     * 必须传true
     */
    private final Boolean fakeMode;
    /**
     * 表单列表
     */
    private final List<FormComponent> formComponentList;

    private final Boolean hidden;
    /**
     * 模板名称。需确保模板名称（即name字段）的全局唯一性
     */
    private final String name;

}
