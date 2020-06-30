package com.ssp.ding;

import com.ssp.ding.request.DingChatCreateRequest;
import com.ssp.ding.request.DingChatUpdateRequest;
import com.ssp.ding.response.DingChatCreateResponse;
import com.ssp.ding.response.DingChatResponse;

import java.util.List;

/**
 * 群会话管理
 *
 * @author: sunshaoping
 * @date: Create by in 4:10 下午 2020/6/24
 */
public interface DingChatService {

    /**
     * 创建会话(群)
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/create?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/Yv89z
     */
    DingChatCreateResponse create(DingChatCreateRequest request);

    /**
     * 修改会话(群)
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/isu6nk/be1caa34
     *
     * @param chatId  群会话的id
     * @param request 更新数据
     */
    void update(String chatId, DingChatUpdateRequest request);


    /**
     * 获取会话
     * <p>
     * 请求地址：https://oapi.dingtalk.com/chat/get?access_token=ACCESS_TOKEN
     * <p>
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

    /**
     * 设置群管理员
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/chat/subadmin/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/leqbe8
     *  @param chatId  群会话id
     * @param userIds 群成员userid列表
     * @param role    2是添加为管理员，3是删除该管理员
     */
    void subAdminUpdate(String chatId, List<String> userIds, Integer role);
}
