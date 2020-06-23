package com.ssp.ding;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 钉钉回到默认存储
 *
 * @author: sunshaoping
 * @date: Create by in 11:00 上午 2020/6/23
 */
@Getter
@RequiredArgsConstructor
public class DefaultDingCallbackConfigStorage implements DingCallbackConfigStorage {

    private final String token;

    private final String aesKey;

    private final String corpId;

    private final String callbackUrl;
}
