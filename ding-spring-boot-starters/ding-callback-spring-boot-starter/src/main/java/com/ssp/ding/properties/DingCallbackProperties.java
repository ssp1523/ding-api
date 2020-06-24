package com.ssp.ding.properties;

import com.ssp.ding.DingCallbackConfigStorage;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.ssp.ding.properties.DingCallbackProperties.PREFIX;

/**
 * 回到配置
 *
 * @author: sunshaoping
 * @date: Create by in 11:03 上午 2020/6/23
 */

@Data
@ConfigurationProperties(prefix = PREFIX)
public class DingCallbackProperties implements DingCallbackConfigStorage {

    public static final String PREFIX = "ding.callback";

    private boolean enabled = true;

    private String token;

    private String aesKey;

    private String corpId;

    private String callbackUrl;
}
