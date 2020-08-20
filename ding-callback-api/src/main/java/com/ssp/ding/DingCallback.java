package com.ssp.ding;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;
import java.util.List;

/**
 * 回调信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:02 下午 2020/6/19
 */
@Getter
@Builder
public class DingCallback {

    /**
     * 数据加密密钥。用于回调数据的加密，
     * 长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成，
     * ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
     */
    private final String aesKey;
    /**
     * 需要监听的事件类型
     */
    private final Collection<String> callBackTag;
    /**
     * 加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，
     * 普通企业可以随机填写
     */
    private final String token;
    /**
     * 接收事件回调的url，必须是公网可以访问的url地址
     */
    private final String url;

}
