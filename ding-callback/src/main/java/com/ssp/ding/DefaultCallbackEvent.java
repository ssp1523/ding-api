package com.ssp.ding;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.handler.CallbackEvent;
import lombok.Data;

/**
 * 回调事件默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 3:45 下午 2020/6/23
 */
@Data
public class DefaultCallbackEvent implements CallbackEvent {

    @JsonProperty("EventType")
    private String eventType;

}
