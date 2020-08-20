package com.ssp.ding;

import com.ssp.ding.request.*;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingProcessTaskResponse;
import com.ssp.ding.response.DingUserTaskResponse;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 工作流待办事项
 *
 * 案例介绍:https://ding-doc.dingtalk.com/doc#/serverapi2/lakp6g
 *
 * 待办授权说明:https://ding-doc.dingtalk.com/doc#/serverapi2/mgu0gr
 *
 *
 * @author: sunshaoping
 * @date: Create by in 3:37 下午 2020/6/17
 */
public interface DingProcessWorkRecordTaskService {


    /**
     * 创建待办事项
     * <p>
     * 通过调用此接口，可以把待办事项的审批节点信息同步到钉钉待办。一个待办实例下最多创建100个待办事项。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/workrecord/task/create?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/rbe7gs
     *
     * @param createRequest 待办数据
     * @return 待办列表
     */
    List<DingProcessTaskResponse> create(DingProcessTaskCreateRequest createRequest);


    /**
     * 更新待办状态
     * <p>
     * 企业调用此接口，可以更新待办任务的状态
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/workrecord/task/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/riycru
     *
     * @param agentId           企业应用标识
     * @param processInstanceId 实例id，通过{@link #create(DingProcessTaskCreateRequest) 创建待办实例接口}获取
     * @param tasks             任务列表
     */
    void update(@Nullable Long agentId, String processInstanceId, List<TaskTopRequest> tasks);

    /**
     * @see #update(Long, String, List)
     */
    default void update(String processInstanceId, List<TaskTopRequest> tasks) {
        update(null, processInstanceId, tasks);
    }


    /**
     * 批量取消待办
     * <p>
     * 企业调用此接口，可以实现在或签等场景下，批量将正在运行中的待办事项设置为CANCELED。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/workrecord/taskgroup/cancel?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/yaiekm
     *
     * @param request 待办取消数据
     */
    void cancel(DingCancelRequest request);

    /**
     * 查询用户待办列表
     * <p>
     * 调用此接口，可以查询用户的待办任务。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/workrecord/task/query?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/riueql
     *
     * @param pageable     分页
     * @param queryRequest 查询数据
     * @return 用户待办分页数据
     */
    DingPage<DingUserTaskResponse> query(DingPageable pageable, DingUserTaskQueryRequest queryRequest);

    /**
     * @see #query(DingUserTaskQueryRequest)
     */
    default DingPage<DingUserTaskResponse> query(DingUserTaskQueryRequest queryRequest) {
        return query(DingPageable.DEFAULT_20, queryRequest);
    }


}
