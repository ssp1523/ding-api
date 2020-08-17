package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 创建工作流实例
 *
 * @author: sunshaoping
 * @date: Create by in 5:20 下午 2020/6/17
 */
@Getter
@Builder
public class DingProcessInstanceCreateRequest {


    /**
     * 企业应用标识(ISV调用必须设置)
     */
    private final Long agentId;
    /**
     * 审批流的唯一码，process_code就在审批流编辑的页面URL中
     */
    private final String processCode;
    /**
     * 审批实例发起人的userid
     */
    private final String originatorUserId;
    /**
     * 审批人userid列表，最大列表长度20。
     * <p>
     * 多个审批人用逗号分隔，按传入的顺序依次审批
     */
    private final List<String> approvers;
    /**
     * 审批人列表。
     * <p>
     * 支持会签/或签，优先级高于approvers变量
     */
    private final List<ProcessInstanceApprover> approversV2;
    /**
     * 抄送人userid列表，最大列表长度：20。多个抄送人用逗号分隔。
     * <p>
     * 该参数需要与cc_position参数一起传，抄送人才会生效；
     * <p>
     * 该参数需要与approvers或approvers_v2参数一起传，抄送人才会生效；
     */
    private final List<String> ccList;
    /**
     * 抄送时间，分为（START, FINISH, START_FINISH）
     */
    private final CCPosition ccPosition;
    /**
     * 发起人所在的部门。
     * <p>
     * 如果发起人属于根部门，传-1
     */
    private final Long deptId;
    /**
     * 审批流表单控件，最大列表长度20。
     * <p>
     * 控件仅支持本文档中列出的<a href="https://ding-doc.dingtalk.com/doc#/serverapi2/cmct1a/f35671bf">表单控件</a>，使用不支持的控件会提示错误
     */
    private final List<FormComponentValue> formComponentValues;

}
