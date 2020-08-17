package com.ssp.ding.config;

import lombok.Data;

/**
 * 钉钉配置 <br/>
 * <a href="https://ding-doc.dingtalk.com/doc#/serverapi3/hv357q">官方文档</a>
 *
 * @author: sunshaoping
 * @date: Create by in 1:48 下午 2020/6/7
 */
@Data
public class DingConfig {


    /**
     * 应用的唯一标识key
     */
    private String appKey;

    /**
     * 应用的密钥
     */
    private String appSecret;

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    private String aesKey;

    /**
     * 加解密需要用到的token
     */
    private String token;

    /**
     * 企业id
     */
    private String corpId;

    /**
     * api 基本域名
     */
    private String baseApi = "https://oapi.dingtalk.com";

    private Redis redis = new Redis();

    @Data
    public static class Redis {

        private String accessTokenLockPrefix = "ding:access:lock";

        private String accessTokenPrefix = "ding:access:token";

        private String jsApiTicketPrefix = "ding:jat:lock";

        private String JsApiTicketLockPrefix = "ding:jat:token";

    }


}
