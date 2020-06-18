package com.ssp.ding.api;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.message.DingMessage;

import java.util.List;

/**
 * 发送普通消息服务
 * <p>
 * 普通会话消息是指员工个人在使用应用时，可以通过界面操作的方式往群或其他人的会话里推送消息，例如发送日志的场景。
 * <p>
 * 发送普通消息，需要在前端页面调用JSAPI唤起联系人会话选择页面，选中后会返回会话cid，然后再调用服务端接口向会话里发送一条消息。
 *
 * @author: sunshaoping
 * @date: Create by in 2:24 下午 2020/6/16
 */
public interface DingConversationService {


    /**
     * @param sender  消息发送者 userId
     * @param cid     群会话或者个人会话的id，通过JSAPI接口唤起联系人界面选择会话获取会话cid；
     *                小程序可参考<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e#38af4599">文档</a>，
     *                H5微应用可参考<a href="https://ding-doc.dingtalk.com/doc#/dev/ou0lte#38af4599">文档</a>
     * @param message 消息内容，消息类型和样例可参考“<a href="https://ding-doc.dingtalk.com/doc#/serverapi3/xxxza0">消息类型与数据格式</a>”文档。最长不超过2048个字节
     * @return 有效接收消息的员工的userId
     */
    List<String> sendToConversation(String sender, String cid, DingMessage message) throws DingException;
}
