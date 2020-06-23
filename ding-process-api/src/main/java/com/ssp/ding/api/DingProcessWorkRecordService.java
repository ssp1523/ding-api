package com.ssp.ding.api;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.ProcessInstanceRequest;
import com.ssp.ding.request.ProcessInstanceUpdateRequest;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 工作流实例
 *
 * @author: sunshaoping
 * @date: Create by in 2:23 下午 2020/6/17
 */
public interface DingProcessWorkRecordService {


    /**
     * 创建实例
     * <p>
     * 企业调用此接口，可以将工作流中的表单参数同步到钉钉审批。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/workrecord/create?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/xfg2g9
     *
     * @param instance 工作流实例
     * @return 实例id
     */
    String create(ProcessInstanceRequest instance) throws DingException;


    /**
     * 更新实例状态
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/workrecord/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/as4xlh/kIMCN
     *
     * @param agentId  企业应用标识
     * @param instance 更新内容
     */
    void update(@Nullable Long agentId, ProcessInstanceUpdateRequest instance) throws DingException;


    /**
     * 批量更新实例状态
     *
     * @param agentId   企业应用标识
     * @param instances 实例列表
     */
    void batchUpdate(Long agentId, List<ProcessInstanceUpdateRequest> instances) throws DingException;


}
