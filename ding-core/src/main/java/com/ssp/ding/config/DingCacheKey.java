package com.ssp.ding.config;

/**
 * 钉钉缓存key
 *
 * @author: sunshaoping
 * @date: Create by in 1:50 下午 2020/8/17
 */
public interface DingCacheKey {

    String getAccessTokenKey();

    String getAccessTokenLockKey();

    String getJsApiTicketKey();

    String getJsApiTicketLockKey();

}
