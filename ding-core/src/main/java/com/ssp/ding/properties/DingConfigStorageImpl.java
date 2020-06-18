package com.ssp.ding.properties;

import cn.hutool.core.util.ObjectUtil;
import com.ssp.ding.DingConfigStorage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * 默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 6:34 下午 2020/6/7
 */
public class DingConfigStorageImpl implements DingConfigStorage {

    private final DingProperties dingProperties;

    private final Token token = new Token();

    private final Token ticket = new Token();



    public DingConfigStorageImpl(DingProperties dingProperties) {
        this.dingProperties = dingProperties;
    }


    @Override
    public String getAppKey() {
        return dingProperties.getAppKey();
    }

    @Override
    public String getAppSecret() {
        return dingProperties.getAppSecret();
    }



    @Override
    public String getAccessToken() {
        if (accessTokenExpired()) {
            token.setValue(null);
            token.setExpireTime(null);
            return null;
        }
        return token.getValue();
    }

    protected boolean accessTokenExpired() {
        return ObjectUtil.isEmpty(token.getExpireTime()) || token.getExpireTime().isAfter(LocalDateTime.now());
    }

    @Override
    public void expireAccessToken() {
        token.setExpireTime(null);
    }

    @Override
    public void updateAccessToken(String accessToken, Duration expiresIn) {
        token.setValue(accessToken);
        token.setExpireTime(LocalDateTime.now().plus(expiresIn));
    }

    @Override
    public Duration getAccessExpires() {
        return Duration.between(token.getExpireTime(), LocalDateTime.now());
    }

    @Override
    public <T> T accessTokenLock(Supplier<T> supplier) {
        Lock lock = token.getLock();
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getJsApiTicket() {
        if (jsApiTicketExpired()) {
            ticket.setValue(null);
            ticket.setExpireTime(null);
            return null;
        }
        return ticket.getValue();
    }

    private boolean jsApiTicketExpired() {
        return ObjectUtil.isEmpty(ticket.getExpireTime()) || ticket.getExpireTime().isAfter(LocalDateTime.now());
    }

    @Override
    public void expireJsApiTicket() {
        ticket.setExpireTime(null);
    }

    @Override
    public void updateJsApiTicket(String jsApiTicket, Duration expiresIn) {
        ticket.setValue(jsApiTicket);
        ticket.setExpireTime(LocalDateTime.now().plus(expiresIn));
    }

    @Override
    public Duration getJsApiTicketExpires() {
        return Duration.between(ticket.getExpireTime(), LocalDateTime.now());
    }

    @Override
    public <T> T jsApiTicketLock(Supplier<T> supplier) {
        Lock lock = ticket.getLock();
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    /**
     * token 配置
     *
     * @author: sunshaoping
     * @date: Create by in 11:14 上午 2020/6/10
     */
    public static class Token {

        private Lock lock = new ReentrantLock();

        private String value;

        private LocalDateTime expireTime;

        public Lock getLock() {
            return lock;
        }

        public void setLock(Lock lock) {
            this.lock = lock;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public LocalDateTime getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(LocalDateTime expireTime) {
            this.expireTime = expireTime;
        }
    }
}
