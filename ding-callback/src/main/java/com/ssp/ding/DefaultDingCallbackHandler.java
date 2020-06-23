package com.ssp.ding;

import com.google.common.collect.ImmutableSet;
import com.ssp.ding.handler.DingCallbackHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.util.Set;

/**
 * 默认实现钉钉回调,处理一些验证消息
 *
 * @author: sunshaoping
 * @date: Create by in 3:52 下午 2020/6/20
 */
@Slf4j
@RequiredArgsConstructor
public class DefaultDingCallbackHandler implements DingCallbackHandler<DefaultCallbackEvent> {
    /**
     * 创建应用，验证回调URL创建有效事件（第一次保存回调URL之前）
     */
    private static final String EVENT_CHECK_CREATE_SUITE_URL = "check_create_suite_url";
    /**
     * 创建应用，验证回调URL变更有效事件（第一次保存回调URL之后）
     */
    private static final String EVENT_CHECK_UPDATE_SUITE_URL = "check_update_suite_url";

    /**
     * suite_ticket推送事件
     */
    private static final String EVENT_SUITE_TICKET = "suite_ticket";
    /**
     * 企业授权开通应用事件
     */
    private static final String EVENT_TMP_AUTH_CODE = "tmp_auth_code";

    /**
     * 支持的事件类型
     */
    private static final Set<String> SUPPORT_SET = ImmutableSet.of(
            EVENT_CHECK_CREATE_SUITE_URL,
            EVENT_CHECK_UPDATE_SUITE_URL,
            EVENT_SUITE_TICKET,
            EVENT_TMP_AUTH_CODE
    );

    @Override
    public boolean support(String eventType) {
        return SUPPORT_SET.contains(eventType);
    }

    @Nullable
    @Override
    public Class<DefaultCallbackEvent> parseJsonClass() {
        return DefaultCallbackEvent.class;
    }

    @Override
    public void callback(DefaultCallbackEvent event) {
        String eventType = event.getEventType();
        if (EVENT_CHECK_CREATE_SUITE_URL.equals(eventType)) {
            log.info("验证新创建的回调URL有效性");
        } else if (EVENT_CHECK_UPDATE_SUITE_URL.equals(eventType)) {
            log.info("验证更新回调URL有效性");
        } else if (EVENT_SUITE_TICKET.equals(eventType)) {
            //suite_ticket用于用签名形式生成accessToken(访问钉钉服务端的凭证)，需要保存到应用的db。
            //钉钉会定期向本callback url推送suite_ticket新值用以提升安全性。
            //应用在获取到新的时值时，保存db成功后，返回给钉钉success加密串（如本demo的return）
            log.info("应用suite_ticket数据推送 ");
        } else if (EVENT_TMP_AUTH_CODE.equals(eventType)) {
            //本事件应用应该异步进行授权开通企业的初始化，目的是尽最大努力快速返回给钉钉服务端。用以提升企业管理员开通应用体验
            //即使本接口没有收到数据或者收到事件后处理初始化失败都可以后续再用户试用应用时从前端获取到corpId并拉取授权企业信息，
            // 进而初始化开通及企业。
            log.info("企业授权开通应用事件");
        }
    }

}
