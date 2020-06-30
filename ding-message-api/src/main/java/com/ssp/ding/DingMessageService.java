package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingChatCreateRequest;
import com.ssp.ding.request.DingCursorPageable;
import com.ssp.ding.response.DingCursorPage;

import java.util.List;

/**
 * 发送消息
 *
 * @author: sunshaoping
 * @date: Create by in 6:03 下午 2020/6/15
 */
public interface DingMessageService {

    /**
     * 发送群消息
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/send?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/eozsg
     *
     * @param chatId 群会话的id，可以通过以下方式获取：
     *               <p>
     *               （1）调用服务端API获取。调用{@link DingChatService#create(DingChatCreateRequest) 创建群会话 }接口的返回chatid字段
     *               <p>
     *               （2）调用前端API获取。小程序调用<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e/edaa2d05">选择会话</a>获取，
     *               H5微应用调用<a href="https://ding-doc.dingtalk.com/doc#/dev/ou0lte/7084ab91">根据corpid选择会话</a>获取。
     * @return 加密的消息id, 如果发送媒体类型消息请先上传文件 {@link #mediaService()}
     * @see DingMediaService
     */
    DingMessageSender<String> sendChat(String chatId);

    /**
     * 查询群消息已读人员列表
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/getReadList?access_token=ACCESS_TOKEN&messageId=MESSAGEID&cursor=CURSOR&size=SIZE
     * <p>
     * 接口地址:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/54a074e0
     *
     * @param pageable  分页
     * @param messageId 发送群消息接口返回的加密消息id(消息id中包含url特殊字符时需要encode后再使用)
     * @return 已读人员的userId列表。已读人员为空时不返回该参数
     */
    DingCursorPage<String> getReadList(DingCursorPageable pageable, String messageId);


    default DingCursorPage<String> getReadList(String messageId) {
        return getReadList(DingCursorPageable.DEFAULT_20, messageId);
    }


    /**
     * 发送普通消息
     * <p>
     * 发送普通消息是指员工个人在使用应用时，可以通过界面操作的方式往群或其他人的会话里推送消息，例如发送日志的场景。发送普通消息，
     * 需要在前端页面调用JSAPI唤起联系人会话选择页面，选中后会返回会话cid，然后再调用服务端接口向会话里发送一条消息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/message/send_to_conversation?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pm0m06
     *
     * @param sender 消息发送者 userId
     * @param cid    群会话或者个人会话的id，通过JSAPI接口唤起联系人界面选择会话获取会话cid；
     *               小程序可参考<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e#38af4599">文档</a>，
     *               H5微应用可参考<a href="https://ding-doc.dingtalk.com/doc#/dev/ou0lte#38af4599">文档</a>
     * @return 有效接收消息的员工的userId
     */
    DingMessageSender<List<String>> sendToConversation(String sender, String cid) throws DingException;

    /**
     * 媒体上传服务
     */
    DingMediaService mediaService();

}
