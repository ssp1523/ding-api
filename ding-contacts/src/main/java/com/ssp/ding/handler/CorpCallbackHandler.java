package com.ssp.ding.handler;

import com.ssp.ding.event.CorpCallbackEvent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;

/**
 * 企业变更回调处理
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/tvgq1n
 *
 * @author: sunshaoping
 * @date: Create by in 3:49 下午 2020/6/19
 */
@Slf4j
public abstract class CorpCallbackHandler implements DingCallbackHandler<CorpCallbackEvent> {

    /**
     * 企业被解散
     */
    public static final String ORG_REMOVE = "org_remove";

    /**
     * 企业信息发生变更
     */
    public static final String ORG_CHANGE = "org_change";


    @Nullable
    @Override
    public Class<CorpCallbackEvent> parseJsonClass() {
        return CorpCallbackEvent.class;
    }

    @Override
    public void callback(CorpCallbackEvent event) {
        corpCallback(event.getEventType(), event.getCorpId());

    }


    /**
     * @param eventType 事件类型
     * @param corpId    企业ID
     */
    protected abstract void corpCallback(String eventType, String corpId);

}
