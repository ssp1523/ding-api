package com.ssp.ding.config;

/**
 * 缓存
 *
 * @author: sunshaoping
 * @date: Create by in 2:42 下午 2020/8/17
 */
public class DefaultDingCacheKey implements DingCacheKey {

    private final DingConfig dingConfig;

    public DefaultDingCacheKey(DingConfig dingConfig) {
        this.dingConfig = dingConfig;
    }


    @Override
    public String getAccessTokenKey() {
        DingConfig.Redis redis = dingConfig.getRedis();
        return redis.getAccessTokenPrefix();
    }

    @Override
    public String getAccessTokenLockKey() {
        DingConfig.Redis redis = dingConfig.getRedis();
        return redis.getAccessTokenLockPrefix();
    }

    @Override
    public String getJsApiTicketKey() {
        DingConfig.Redis redis = dingConfig.getRedis();
        return redis.getJsApiTicketPrefix();
    }

    @Override
    public String getJsApiTicketLockKey() {
        DingConfig.Redis redis = dingConfig.getRedis();
        return redis.getJsApiTicketLockPrefix();
    }
}
