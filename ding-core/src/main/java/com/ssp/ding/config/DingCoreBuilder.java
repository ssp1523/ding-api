package com.ssp.ding.config;

import cn.hutool.core.lang.Singleton;
import cn.hutool.core.lang.func.Func0;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.DingConfigStorage;
import com.ssp.ding.DingService;
import com.ssp.ding.conf.DingConf;
import com.ssp.ding.convert.ConverterConfigurer;
import com.ssp.ding.service.DingClient;
import com.ssp.ding.service.DingLogger;
import com.ssp.ding.service.DingTalkClientFactory;
import com.ssp.ding.service.impl.DefaultDingLogger;
import com.ssp.ding.service.impl.DefaultDingService;
import com.ssp.ding.service.impl.DefaultDingTalkClientFactory;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * 钉钉核心模块构建
 *
 * @author: sunshaoping
 * @date: Create by in 10:28 上午 2020/8/14
 */
public class DingCoreBuilder implements DingConf {


    private final DingConfig dingConfig;


    protected DingCoreBuilder(DingConfig dingConfig) {
        this.dingConfig = dingConfig;
    }

    public static DingCoreBuilder create(DingConfig dingConfig) {
        return computeIfAbsent(DING_CORE_BUILDER, () -> new DingCoreBuilder(dingConfig));
    }

    public DingConfig dingConfig() {
        return dingConfig;
    }

    /**
     * 添加转换配置
     */
    public DingCoreBuilder addConverterConfigurer(ConverterConfigurer converterConfigurer) {
        converterConfigurer.converter(dingConversionService());
        return this;
    }

    /**
     * 类型转换器
     */
    public ConfigurableConversionService dingConversionService() {
        return computeIfAbsent(DING_CONVERSION_SERVICE, DefaultConversionService::new);
    }

    /**
     * json ObjectMapper
     */
    public ObjectMapper objectMapper() {
        return computeIfAbsent(DING_OBJECT_MAPPER, () -> {
            ObjectMapper objectMapper = new ObjectMapper();
            //单引号
            objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            //无引号
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            return objectMapper;
        });
    }


    public DingService dingService() {
        return computeIfAbsent(DING_SERVICE,
                () -> new DefaultDingService(dingConfigStorage(), dingTalkClientFactory(), dingLogger(), dingConversionService())
        );
    }

    public DingClient dingClient() {
        return (DingClient) dingService();
    }

    public DingLogger dingLogger() {
        return computeIfAbsent(DING_LOGGER, DefaultDingLogger::new);
    }

    public DingConfigStorage dingConfigStorage() {
        return computeIfAbsent(DING_CONFIG_STORAGE, () -> new DingConfigStorageImpl(dingConfig));
    }

    public DingTalkClientFactory dingTalkClientFactory() {
        return computeIfAbsent(DING_TALK_CLIENT_FACTORY, () -> new DefaultDingTalkClientFactory(dingConfig));
    }


    private static <T> T computeIfAbsent(String key, Func0<T> func0) {
        return Singleton.get(key, func0);
    }


}
