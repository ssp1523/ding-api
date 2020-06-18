package com.ssp.ding.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.ssp.ding.properties.DingProperties.PREFIX;

/**
 * 钉钉配置 <br/>
 * <a href="https://ding-doc.dingtalk.com/doc#/serverapi3/hv357q">官方文档</a>
 *
 * @author: sunshaoping
 * @date: Create by in 1:48 下午 2020/6/7
 */
@Data
@ConfigurationProperties(PREFIX)
public class DingProperties {

    public static final String PREFIX = "ding";


    /**
     * 应用的唯一标识key
     */
    private String appKey;

    /**
     * 应用的密钥
     */
    private String appSecret;


    /**
     * api 基本域名
     */
    private String baseApi = "https://oapi.dingtalk.com";

}
