package com.ssp.ding.config;

import com.ssp.ding.DingConfigStorage;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.function.Supplier;

/**
 * redisson 实现redis配置存储
 *
 * @author: sunshaoping
 * @date: Create by in 1:35 下午 2020/8/17
 */
@RequiredArgsConstructor
public class RedissonConfigStorage implements DingConfigStorage {

    private final DingConfig dingConfig;

    private final DingCacheKey cacheKey;

    private final RedissonClient redisson;

    @Override
    public String getAppKey() {
        return dingConfig.getAppKey();
    }

    @Override
    public String getAppSecret() {
        return dingConfig.getAppSecret();
    }

    @Override
    public String getAccessToken() {
        return getAccessTokenBucket().get();
    }


    private RBucket<String> getAccessTokenBucket() {
        String key = cacheKey.getAccessTokenKey();
        return redisson.getBucket(key);
    }


    @Override
    public void expireAccessToken() {
        getAccessTokenBucket().delete();
    }

    @Override
    public void updateAccessToken(String accessToken, Duration expiresIn) {
        getAccessTokenBucket().set(accessToken, expiresIn.toNanos(), TimeUnit.SECONDS);
    }

    @Override
    public <T> T accessTokenLock(Supplier<T> supplier) {
        RLock lock = redisson.getLock(cacheKey.getAccessTokenLockKey());
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getJsApiTicket() {
        return getJsApiTicketBucket().get();
    }

    private RBucket<String> getJsApiTicketBucket() {
        String key = cacheKey.getJsApiTicketKey();
        return redisson.getBucket(key);
    }

    @Override
    public void expireJsApiTicket() {
        getJsApiTicketBucket().delete();
    }

    @Override
    public void updateJsApiTicket(String jsApiTicket, Duration expiresIn) {
        getJsApiTicketBucket().set(jsApiTicket, expiresIn.toNanos(), TimeUnit.NANOSECONDS);
    }

    @Override
    public <T> T jsApiTicketLock(Supplier<T> supplier) {
        Lock lock = redisson.getLock(cacheKey.getJsApiTicketLockKey());
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }
}
