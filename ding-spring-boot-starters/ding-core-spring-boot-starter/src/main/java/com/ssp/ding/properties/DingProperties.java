package com.ssp.ding.properties;

import com.ssp.ding.config.DingConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.ssp.ding.properties.DingProperties.PREFIX;

/**
 * 钉钉配置
 *
 * @author: sunshaoping
 * @date: Create by in 10:30 上午 2020/6/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(prefix = PREFIX)
public class DingProperties extends DingConfig {

    public static final String PREFIX = "ding";

    /**
     * 是否开启
     */
    private boolean enabled = true;

}
