package com.ssp.ding.configuration;

import com.ssp.ding.DingConfigStorage;
import com.ssp.ding.DingService;
import com.ssp.ding.config.DefaultDingCacheKey;
import com.ssp.ding.config.DingCacheKey;
import com.ssp.ding.config.DingConfigStorageImpl;
import com.ssp.ding.config.RedissonConfigStorage;
import com.ssp.ding.properties.DingProperties;
import com.ssp.ding.service.DingLogger;
import com.ssp.ding.service.DingTalkClientFactory;
import com.ssp.ding.service.impl.DefaultDingLogger;
import com.ssp.ding.service.impl.DefaultDingService;
import com.ssp.ding.service.impl.DefaultDingTalkClientFactory;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.support.ConfigurableConversionService;

import static com.ssp.ding.conf.DingConf.DING_CONVERSION_SERVICE;

/**
 * 钉钉自动装配
 *
 * @author: sunshaoping
 * @date: Create by in 4:24 下午 2020/6/7
 */
@Configuration
@Import(ConverterConfiguration.class)
@RequiredArgsConstructor
@EnableConfigurationProperties(DingProperties.class)
@ConditionalOnClass(DingService.class)
@ConditionalOnProperty(prefix = DingProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class DingConfiguration {

    private final DingProperties dingProperties;

    @Bean
    @ConditionalOnMissingBean(name = "dingService")
    public DefaultDingService dingService(DingConfigStorage dingConfigStorage, DingTalkClientFactory dingTalkClientFactory, DingLogger logger,
                                          @Qualifier(DING_CONVERSION_SERVICE) ConfigurableConversionService conversionService) {
        return new DefaultDingService(dingConfigStorage, dingTalkClientFactory, logger, conversionService);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingLogger dingLogger() {
        return new DefaultDingLogger();
    }

    /**
     * 默认配置
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "ding", name = "storage-type", havingValue = "default", matchIfMissing = true)
    public DingConfigStorage dingConfigStorage() {
        return new DingConfigStorageImpl(dingProperties);
    }


    @Bean
    @ConditionalOnMissingBean
    public DingCacheKey cacheKey() {
        return new DefaultDingCacheKey(dingProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public DingTalkClientFactory dingTalkClientFactory() {
        return new DefaultDingTalkClientFactory(dingProperties);
    }

    @Configuration
    @ConditionalOnProperty(prefix = "ding", name = "storage-type", havingValue = "redis")
    public class RedissonStorageConfiguration {
        /**
         * redis 配置
         */
        @Bean
        @ConditionalOnMissingBean
        public DingConfigStorage dingRedissonConfigStorage(RedissonClient redisson) {
            return new RedissonConfigStorage(dingProperties, new DefaultDingCacheKey(dingProperties), redisson);
        }
    }

}


