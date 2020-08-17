package com.ssp.ding.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.ssp.ding.DingApi;
import com.ssp.ding.config.DingConfig;
import com.ssp.ding.service.DingTalkClientFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: sunshaoping
 * @date: Create by in 6:25 下午 2020/6/10
 */
public class DefaultDingTalkClientFactory implements DingTalkClientFactory {

    private final ConcurrentMap<String, DingTalkClient> dingTalkClientCache = new ConcurrentHashMap<>();

    private final DingConfig dingConfig;

    public DefaultDingTalkClientFactory(DingConfig dingConfig) {
        this.dingConfig = dingConfig;
    }

    @Override
    public DingTalkClient getClient(DingApi dingApi) {
        String url =
                UriComponentsBuilder.fromHttpUrl(dingConfig.getBaseApi())
                        .path(dingApi.getPath())
                        .toUriString();
        return dingTalkClientCache.computeIfAbsent(url, this::getClient0);


    }

    protected DingTalkClient getClient0(String url) {
        return new DefaultDingTalkClient(url);
    }


}
