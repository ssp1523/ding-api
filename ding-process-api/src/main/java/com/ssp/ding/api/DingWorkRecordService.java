package com.ssp.ding.api;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingWorkRecordRequest;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingWorkRecordResponse;

/**
 * 待办任务
 * <p>
 * 案例介绍:https://ding-doc.dingtalk.com/doc#/serverapi2/lakp6g
 * <p>
 * 待办权限说明:https://ding-doc.dingtalk.com/doc#/serverapi2/mgu0gr
 *
 * @author: sunshaoping
 * @date: Create by in 10:51 上午 2020/6/18
 */
public interface DingWorkRecordService {


    /**
     * 发起待办
     * <p>
     * 企业可以调用该接口发起一个待办事项,该待办事项会出现在钉钉客户端“待办事项”页面，与钉钉审批待办事项并列。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/workrecord/add?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/gpmpiq/8bRxA
     *
     * @param workRecordRequest 待办事项数据
     * @return 待办事项唯一id，更新待办事项的时候需要用到
     */
    String add(DingWorkRecordRequest workRecordRequest) throws DingException;

    /**
     * 更新待办
     * 企业可以调用该接口更新待办事项状态，调用成功后，该待办事项在该用户的“待办事项”列表页面中消失。
     *
     * @param userId   待办事项对应的用户id
     * @param recordId 待办事项唯一id。
     *                 <p>
     *                 该id可以使用{@link #add(DingWorkRecordRequest) 创建待办接口}中传入的{@link DingWorkRecordRequest#getBizId()}或返回值
     */
    void update(String userId, String recordId) throws DingException;


    /**
     * 获取用户待办事项
     * <p>
     * 企业可以调用该接口分页获取用户的待办任务列表，仅能获取通过调用{@link #add(DingWorkRecordRequest) 发起待办接口}创建的任务列表。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/workrecord/getbyuserid?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/neevhm
     *
     * @param pageable 分页
     * @param userId   待办事项对应的用户id
     * @param status   待办事项状态，0表示未完成，1表示完成
     */
    DingPage<DingWorkRecordResponse> getByUserId(DingPageable pageable, String userId, Integer status) throws DingException;
}
