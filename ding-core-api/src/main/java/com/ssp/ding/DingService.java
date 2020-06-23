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
     * 当您开发新的企业应用，或者将您企业内部的系统接入到钉钉。企业员工在钉钉内使用该应用，当员工点击应用时，无需输入账户密码，便可实现自动登录您所开发的系统。
     * 使用该接口,获取用户userid
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/clotub/06a06850
     *
     * @param code 免登授权码，参考:<a href="https://ding-doc.dingtalk.com/doc#/serverapi2/clotub/e3962c98">获取免登授权码</a>
     */
    DingUserInfoResponse getUserInfo(String code);

    /**
     * 第一种情况:https://ding-doc.dingtalk.com/doc#/serverapi2/kymkv6
     * 扫码登录第三方网站
     * 当您开发了一个独立的网站，但是希望用户以钉钉的账号登录您的网站时，可以通过钉钉扫码方式实现免密登录此网站。注意此网站并不是钉钉客户端内使用的企业/ISV应用。
     * 第二种情况:https://ding-doc.dingtalk.com/doc#/serverapi2/etaarr
     * 钉钉内免登第三方网站
     * 当您开发的H5网站在钉钉客户端内打开，只需要用户直接点击H5链接，便可以免输入钉钉账户密码实现自动登录的流程。注意此网站并不是钉钉客户端内使用的企业应用/第三方企业应用。
     * 第三种情况:https://ding-doc.dingtalk.com/doc#/serverapi2/hmxp3f
     * 密码登录独立的第三方网站
     * 当您开发了一个独立的网站，希望以钉钉的账号登录您的网站时，可以通过展现钉钉提供的登录URL的页面，用户输入钉钉账户密码后实现登录您的网站的流程。注意此网站并不是钉钉客户端内使用的企业应用/第三方应用。
     * 以上三种情况可以使用该接口,获取用户信息
     * <p>
     * 服务端通过临时授权码获取授权用户的个人信息
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/kymkv6/M3fY1
     *
     * @param tmpAuthCode 用户授权的临时授权码code，只能使用一次；在前面步骤中跳转到redirect_uri时会追加code参数
     * @see DingUserService#getUserIdByUnionId(java.lang.String) 根据unionid获取userid
     */
    DingSnsUserInfoResponse getUserInfoByCode(String tmpAuthCode);

}
