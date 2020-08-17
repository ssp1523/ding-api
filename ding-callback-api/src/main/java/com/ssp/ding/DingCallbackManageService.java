package com.ssp.ding;

import com.ssp.ding.response.DingCallBackFailedResponse;
import com.ssp.ding.response.DingPage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 钉钉回调管理
 *
 * @author: sunshaoping
 * @date: Create by in 3:00 下午 2020/6/19
 */
public interface DingCallbackManageService {


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
     * 注册业务事件回调接口,批量
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
     * 接口api
     */
    @Getter
    @RequiredArgsConstructor
    enum Api implements DingApi {

        /**
         * @see #registerCallBack(DingCallback)
         * @see #registerCallBack(List)
         */
        REGISTER_CALL_BACK("/call_back/register_call_back", "注册业务事件回调接口"),
        /**
         * @see #getCallBack()
         */
        GET_CALL_BACK("/call_back/get_call_back", "查询事件回调接口"),
        /**
         * @see #updateCallBack(DingCallback)
         * @see #updateCallBack(List)
         */
        UPDATE_CALL_BACK("/call_back/update_call_back", "更新事件回调接口"),
        /**
         * @see #deleteCallBack()
         */
        DELETE_CALL_BACK("/call_back/delete_call_back", "删除事件回调接口"),
        /**
         * @see #getCallBackFailedResult()
         */
        GET_CALL_BACK_FAILED_RESULT("/call_back/get_call_back_failed_result", "获取回调失败的结果"),

        ;

        private final String path;

        private final String sketch;

    }

}
