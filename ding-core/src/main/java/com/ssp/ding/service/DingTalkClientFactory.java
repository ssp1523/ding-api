package com.ssp.ding.service;

import com.dingtalk.api.DingTalkClient;

/**
 * 钉钉客户端工厂类
 *
 * @author: sunshaoping
 * @date: Create by in 6:26 下午 2020/6/10
 */
public interface DingTalkClientFactory {

    DingTalkClient getClient(String path);
}
