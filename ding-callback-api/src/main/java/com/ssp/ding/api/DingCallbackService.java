package com.ssp.ding.api;

import com.ssp.ding.DingCallback;
import com.ssp.ding.handler.CallbackEvent;
import com.ssp.ding.handler.DingCallbackHandler;
import com.ssp.ding.response.DingCallBackFailedResponse;
import com.ssp.ding.response.DingPage;

import java.util.List;
import java.util.Map;

/**
 * 钉钉回调管理
 *
 * @author: sunshaoping
 * @date: Create by in 3:00 下午 2020/6/19
 */
public interface DingCallbackService {


    /**
     * 注册业务事件回调接口
     * <p>
     * 注册回调接口时，钉钉服务器会向URL发起【测试回调URL】事件，来验证填写url的合法性，url服务器需要在接收到回调之后返回字符串“success”的加密json数据，才能完成注册。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/call_back/register_call_back?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pwz3r5/647274f0
     *
     * @param request 注册信息
     */
    void registerCallBack(DingCallback request);

    /**
     * 注册业务事件回调接口
     *
     * @param callBackTag 事件类型
     */
    void registerCallBack(List<String> callBackTag);


    //    测试回调URL

    /**
     * 查询事件回调接口
     * <p>
     * 请求地址：https://oapi.dingtalk.com/call_back/get_call_back?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pwz3r5/1cd40e12
     *
     * @return 注册回调的信息
     */
    DingCallback getCallBack();

    /**
     * 更新事件回调接口
     * <p>
     * 请求地址：https://oapi.dingtalk.com/call_back/update_call_back?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pwz3r5/2ec909c1
     */
    void updateCallBack(DingCallback request);

    void updateCallBack(List<String> callBackTag);


    /**
     * 删除事件回调接口
     * <p>
     * 请求地址：https://oapi.dingtalk.com/call_back/delete_call_back?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pwz3r5/9350bba9
     */
    void deleteCallBack();

    /**
     * 获取回调失败的结果
     * <p>
     * 钉钉服务器给回调接口推送时，有可能因为各种原因推送失败(比如网络异常)，此时钉钉将保留此次变更事件。用户可以通过此回调接口获取推送失败的变更事件。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/call_back/get_call_back_failed_result?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/pwz3r5/e45c03d0
     *
     * @return 回调失败记录
     */
    DingPage<DingCallBackFailedResponse> getCallBackFailedResult();


    /**
     * 注册钉钉回调处理
     *
     * @param handler 回调处理
     */
    void registerCallBackHandler(DingCallbackHandler<? extends CallbackEvent> handler);

    /**
     * 事件回调处理
     *
     * @param signature   签名
     * @param timestamp   时间戳
     * @param nonce       随机字符串
     * @param encryptJson 加密数据json
     * @return 响应数据, 直接以json格式返回给钉钉即可
     */
    Map<String, String> callBackHandler(String signature, String timestamp, String nonce, String encryptJson);
}
