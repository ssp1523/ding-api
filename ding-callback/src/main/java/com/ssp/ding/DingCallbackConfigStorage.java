package com.ssp.ding;

/**
 * 事件回调配置接口
 *
 * @author: sunshaoping
 * @date: Create by in 3:13 下午 2020/6/20
 */
public interface DingCallbackConfigStorage {

    /**
     * 加解密需要用到的token
     */
    String getToken();

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    String getAesKey();

    /**
     * 企业id
     */
    String getCorpId();

    /**
     * 钉钉回调URL
     */
    String getCallbackUrl();
}
