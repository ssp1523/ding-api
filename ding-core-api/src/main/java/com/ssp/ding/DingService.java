package com.ssp.ding;


import com.ssp.ding.response.DingSnsUserInfoResponse;
import com.ssp.ding.response.DingUserInfoResponse;

/**
 * 钉钉服务
 *
 * @author: sunshaoping
 * @date: Create by in 1:40 下午 2020/6/7
 */
public interface DingService {

    /**
     * 获取AccessToken
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/hv357q
     */
    String getAccessToken();

    /**
     * 刷新 AccessToken,并返回新的 AccessToken
     */
    String refreshAccessToken();

    /**
     * 获取JsApiTicket
     * 接口文档:https://ding-doc.dingtalk.com/doc#/dev/uwa7vs/ce4ef38d
     */
    String getJsApiTicket();

    /**
     * 刷新 JsApiTicket,并返回新的 JsApiTicket
     */
    String refreshJsApiTicket();


    /**
     * 获取钉钉配置信息
     */
    DingConfigStorage getDingConfigStorage();

    /**
     * 企业应用免登:https://ding-doc.dingtalk.com/doc#/serverapi2/clotub
     * <p>
     * 当您开发新的企业应用，或者将您企业内部的系统接入到钉钉。企业员工在钉钉内使用该应用，当员工点击应用时，无需输入账户密码，便可实现自动登录您所开发的系统。
     * 使用该接口,获取用户userid
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/getuserinfo?access_token=access_token&code=code
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/clotub/06a06850
     *
     * @param code 免登授权码，参考:<a href="https://ding-doc.dingtalk.com/doc#/serverapi2/clotub/e3962c98">获取免登授权码</a>
     */
    DingUserInfoResponse getUserInfo(String code);

    /**
     * 服务端通过临时授权码获取授权用户的个人信息
     * <p>
     * 请求地址：https://oapi.dingtalk.com/sns/getuserinfo_bycode?accessKey=xxx&timestamp=xxx&signature=xxx
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/kymkv6/M3fY1
     *
     * @param tmpAuthCode 用户授权的临时授权码code，只能使用一次；在前面步骤中跳转到redirect_uri时会追加code参数
     * @param appId       钉钉应用 appId <a href="https://ding-doc.dingtalk.com/doc#/serverapi2/kymkv6/R9LdV">获取appId及appSecret</a>
     * @param appSecret   钉钉应用 appSecret
     * @see com.ssp.ding.api.DingUserService#getUserIdByUnionId(java.lang.String) 根据unionid获取userid
     */
    DingSnsUserInfoResponse getUserInfoByCode(String tmpAuthCode, String appId, String appSecret);

}
