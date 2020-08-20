package com.ssp.ding.event;

import lombok.Getter;

/**
 * 企业变更回调
 *
 * @author: sunshaoping
 * @date: Create by in 1:43 下午 2020/6/23
 */
@Getter
public class CorpCallbackSpringEvent extends CallbackSpringEvent {


    private final String corpId;

    public CorpCallbackSpringEvent(String eventType, String corpId) {
        super(eventType);
        this.corpId = corpId;
    }
}
