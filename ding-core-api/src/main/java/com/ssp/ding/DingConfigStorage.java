package com.ssp.ding;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * 钉钉配置存储
 *
 * @author: sunshaoping
 * @date: Create by in 4:22 下午 2020/6/7
 */
public interface DingConfigStorage {
    /**
     * 应用的唯一标识key
     */
    String getAppKey();

    /**
     * 应用的密钥
     */
    String getAppSecret();

    /**
     * 获取token,过期返回null
     */
    String getAccessToken();


    /**
     * 强制将access token过期掉.
     */
    void expireAccessToken();

    /**
     * 更新token
     */
    void updateAccessToken(String accessToken, Duration expiresIn);

    /**
     * access token 过期时间
     */
    Duration getAccessExpires();

    /**
     * access token加锁
     *
     * @param supplier 加锁范围
     */
    <T> T accessTokenLock(Supplier<T> supplier);


    /**
     * 获取js api ticket
     */
    String getJsApiTicket();


    /**
     * 强制将js api ticket过期掉.
     */
    void expireJsApiTicket();

    /**
     * 更新token
     */
    void updateJsApiTicket(String jsApiTicket, Duration expiresIn);

    /**
     * js api ticket 过期时间
     */
    Duration getJsApiTicketExpires();

    /**
     * js api ticket 加锁
     *
     * @param supplier 加锁范围
     */
    <T> T jsApiTicketLock(Supplier<T> supplier);


}
