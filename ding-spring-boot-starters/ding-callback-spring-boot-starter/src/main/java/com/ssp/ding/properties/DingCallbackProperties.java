package com.ssp.ding.properties;

import cn.hutool.core.util.StrUtil;
import com.ssp.ding.DingCallbackConfigStorage;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.util.UriComponentsBuilder;

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

    /**
     * 回调开关
     */
    private boolean enabled = true;
    /**
     * 加解密需要用到的token
     */
    private String token;
    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     *
     * @see com.dingtalk.oapi.lib.aes.Utils#getRandomStr(int) 生成秘钥函数
     * <pre>
     *         String randomStr = Utils.getRandomStr(43);
     *         System.out.println(randomStr);
     * </pre>
     */
    private String aesKey;
    /**
     * 企业id
     */
    private String corpId;
    /**
     * 钉钉回调URL
     */
    private String callbackUrl;

}
