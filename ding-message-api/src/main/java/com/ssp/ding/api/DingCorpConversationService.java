package com.ssp.ding.api;

import com.ssp.ding.message.DingMessage;
import com.ssp.ding.request.DingCorpConversationRequest;
import com.ssp.ding.response.DingSendProgressResponse;
import com.ssp.ding.responsei.DingSendResultResponse;

/**
 * 工作通知消息
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pgoxpy/
 * 注意事项
 * 发送工作通知消息需要注意以下事项：
 * <p>
 * 同一个应用相同消息的内容同一个用户一天只能接收一次。
 * 同一个应用给同一个用户发送消息，企业内部开发方式一天不得超过500次。
 * 通过设置to_all_user参数全员推送消息，一天最多3次。
 * 超出以上限制次数后，接口返回成功，但用户无法接收到。详细的限制说明，请参考“工作通知消息的限制”。
 * 该接口是异步发送消息，接口返回成功并不表示用户一定会收到消息，需要通过“查询工作通知消息的发送结果”接口查询是否给用户发送成功。
 * 消息类型和样例可参考消息类型文档。
 *
 * @author: sunshaoping
 * @date: Create by in 5:57 下午 2020/6/15
 */
public interface DingCorpConversationService {

    /**
     * 发送异步工作通知消息
     * <p>
     * 注意事项
     * 发送工作通知消息需要注意以下事项：
     * <p>
     * 同一个应用相同消息的内容同一个用户一天只能接收一次。
     * 同一个应用给同一个用户发送消息，ISV应用开发方式一天不得超过50次。
     * 超出以上限制次数后，接口返回成功，但用户无法接收到。详细的限制说明，请参考“工作通知消息的限制”。
     * 该接口是异步发送消息，接口返回成功并不表示用户一定会收到消息，需要通过本文介绍的“查询工作通知消息的发送结果”接口查询是否给用户发送成功。
     * 消息类型和样例可参考消息类型与数据格式文档。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2?access_token=ACCESS_TOKEN
     * <p>
     * 接口地址:https://ding-doc.dingtalk.com/doc#/serverapi2/pgoxpy/x842X
     *
     * @param request 工作通知消息
     * @param message 消息内容
     * @return 钉钉返回的任务id。仅支持查询24小时内的任务id
     */

    Long asyncSendV2(DingCorpConversationRequest request, DingMessage message);

    /**
     * 查询工作通知消息的发送进度
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/message/corpconversation/getsendprogress?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pgoxpy/e2262dad
     *
     * @param agentId 应用的agentId
     * @param taskId  钉钉返回的任务id。仅支持查询24小时内的任务id
     */
    DingSendProgressResponse getSendProgress(Long agentId, Long taskId);

    /**
     * 查询工作通知消息的发送结果
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pgoxpy/a5920210
     *
     * @param agentId 应用的agentid
     * @param taskId  钉钉返回的任务id。仅支持查询24小时内的任务id
     */
    DingSendResultResponse getSendResult(Long agentId, Long taskId);

    /**
     * 工作通知消息撤回
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/message/corpconversation/recall?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pgoxpy/hYyV8
     *
     * @param agentId 应用的agentid
     * @param taskId  钉钉返回的任务id。仅支持查询24小时内的任务id
     */
    void recall(Long agentId, Long taskId);

}
