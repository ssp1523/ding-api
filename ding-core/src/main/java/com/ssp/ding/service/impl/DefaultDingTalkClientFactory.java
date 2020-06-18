package com.ssp.ding.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.ssp.ding.properties.DingProperties;
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

    private final DingProperties dingProperties;

    public DefaultDingTalkClientFactory(DingProperties dingProperties) {
        this.dingProperties = dingProperties;
    }

    @Override
    public DingTalkClient getClient(String path) {
        String url = UriComponentsBuilder.fromHttpUrl(dingProperties.getBaseApi())
                .path(path)
                .toUriString();
        return dingTalkClientCache.computeIfAbsent(url, this::getClient0);


    }

    protected DingTalkClient getClient0(String url) {
        return new DefaultDingTalkClient(url);
    }


}
