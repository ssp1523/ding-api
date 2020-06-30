package com.ssp.ding;

import com.ssp.ding.enumeration.MediaType;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingChatCreateRequest;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * 发送媒体文件消息
 *
 * @author: sunshaoping
 * @date: Create by in 6:31 下午 2020/6/24
 */
public interface DingMediaMessageService extends DingMediaService, DingMessageService {

    /**
     * 上传并发送消息
     *
     * @param chatId    群会话的id，可以通过以下方式获取：
     *                  <p>
     *                  （1）调用服务端API获取。调用{@link DingChatService#create(DingChatCreateRequest) 创建群会话 }接口的返回chatid字段
     *                  <p>
     *                  （2）调用前端API获取。小程序调用<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e/edaa2d05">选择会话</a>获取，
     * @param mediaType 媒体类型
     * @param resource  上传资源 spring项目使用
     * @return 加密的消息id, 如果发送媒体类型消息请先上传文件 {@link #mediaService()}
     */
    DingMediaMessageSender<String> sendAndUpload(String chatId, MediaType mediaType, Resource resource) throws DingException;

    /**
     * 上传并发送普通消息
     *
     * @param sender    消息发送者 userId
     * @param cid       群会话或者个人会话的id，通过JSAPI接口唤起联系人界面选择会话获取会话cid；
     *                  小程序可参考<a href="https://ding-doc.dingtalk.com/doc#/dev/epcw4e#38af4599">文档</a>，
     *                  H5微应用可参考<a href="https://ding-doc.dingtalk.com/doc#/dev/ou0lte#38af4599">文档</a>
     * @param mediaType 媒体类型
     * @param resource  上传资源 spring项目使用
     * @return 媒体消息发送器
     */
    DingMediaMessageSender<List<String>> sendAndUploadToConversation(String sender, String cid, MediaType mediaType, Resource resource) throws DingException;
}
