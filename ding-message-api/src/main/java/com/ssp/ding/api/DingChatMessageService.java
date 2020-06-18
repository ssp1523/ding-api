package com.ssp.ding.api;

import com.ssp.ding.message.DingMessage;
import com.ssp.ding.request.DingChatCreateRequest;
import com.ssp.ding.request.DingChatUpdateRequest;
import com.ssp.ding.response.DingChatCreateResponse;
import com.ssp.ding.response.DingChatResponse;
import com.ssp.ding.response.DingCursorPage;

/**
 * TODO 发送群消息
 * <p>
 * 群会话消息是指可以调用接口创建企业群聊会话，然后可以以系统名义向群里推送群聊消息。
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk
 *
 * @author: sunshaoping
 * @date: Create by in 6:03 下午 2020/6/15
 */
public interface DingChatMessageService {

    /**
     * 发送群消息
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/send?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/eozsg
     *
     * @param chatId  群会话的id，可以通过以下方式获取：
     *                <p>
     *                （1）调用服务端API获取。调用{@link #create(DingChatCreateRequest) 创建群会话 }接口的返回chatid字段
     *                <p>
     *                （2）调用前端API获取。小程序调用<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e/edaa2d05">选择会话</a>获取，
     *                H5微应用调用<a href="https://ding-doc.dingtalk.com/doc#/dev/ou0lte/7084ab91">根据corpid选择会话</a>获取。
     * @param message 消息内容
     * @return 加密的消息id
     */
    String send(String chatId, DingMessage message);

    /**
     * 查询群消息已读人员列表
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/getReadList?access_token=ACCESS_TOKEN&messageId=MESSAGEID&cursor=CURSOR&size=SIZE
     * <p>
     * 接口地址:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/54a074e0
     *
     * @param cursor    分页查询的游标，第一次可以传0，后续传返回结果中的next_cursor的值。当返回结果中，
     *                  没有next_cursor时，表示没有后续的数据了，可以结束调用
     * @param size      分页查询的大小，最大可以传100
     * @param messageId 发送群消息接口返回的加密消息id(消息id中包含url特殊字符时需要encode后再使用)
     * @return 已读人员的userId列表。已读人员为空时不返回该参数
     */
    DingCursorPage<String> getReadList(Long cursor, Integer size, String messageId);


    default DingCursorPage<String> getReadList(String messageId) {
        return getReadList(0L, 100, messageId);
    }

    /**
     * 创建会话(群)
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/Yv89z
     */
    DingChatCreateResponse create(DingChatCreateRequest request);

    /**
     * 修改会话(群)
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/be1caa34
     *
     * @param chatId  群会话的id
     * @param request 更新数据
     */
    void update(String chatId, DingChatUpdateRequest request);

    /**
     * 获取会话
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/8599dee5
     *
     * @param chatId 群会话的id，可以通过以下方式获取：
     *               <p>
     *               （1）调用服务端API获取。调用{@link #create(DingChatCreateRequest) 创建群会话 }接口的返回chatid字段
     *               <p>
     *               （2）调用前端API获取。小程序调用<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e/edaa2d05">选择会话</a>获取，
     *               H5微应用调用<a href="https://ding-doc.dingtalk.com/doc#/dev/ou0lte/7084ab91">根据corpid选择会话</a>获取。
     */
    DingChatResponse get(String chatId);
}
