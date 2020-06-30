package com.ssp.ding;

import com.ssp.ding.response.DingSsoUserInfoResponse;

/**
 * 应用管理后台免登
 * <p>
 * 管理后台免登流程开发
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/xswxhg/2d7ff095
 * <p>
 * 第一步：获取免登授权码
 * <p>
 * 当企业管理员登录钉钉管理后台后，点击工作台中的应用，会自动跳转到应用的后台地址，钉钉会把code参数追加到此URL地址中
 * <p>
 * 第二步：获取应用后台免登的accessToken {@link #getToken()}
 * <p>
 * 本接口获取的access_token只在微应用后台管理免登服务中使用。
 * <p>
 * 第三步：获取应用管理员的身份信息 {@link #getUserInfo(String)}
 * <p>
 * 使用步骤一获取到的code和步骤二获取到的access_token换取微应用管理员的身份信息。
 *
 * @author: sunshaoping
 * @date: Create by in 5:22 下午 2020/6/15
 */
public interface DingSsoService {


    /**
     * 获取应用后台免登的accessToken
     */
    String getToken();

    /**
     * 强制刷新token
     */
    String refreshToken();

    /**
     * 钉钉配置信息
     */
    DingSsoConfigStorage getSsoConfigStorage();


    /**
     * 获取应用管理员的身份信息
     *
     * @param code 通过Oauth认证给URL带上的CODE。
     */
    DingSsoUserInfoResponse getUserInfo(String code);

}
