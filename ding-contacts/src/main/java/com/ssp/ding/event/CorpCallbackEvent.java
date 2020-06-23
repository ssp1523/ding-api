package com.ssp.ding.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssp.ding.DefaultCallbackEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门回调事件
 *
 * @author: sunshaoping
 * @date: Create by in 3:53 下午 2020/6/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CorpCallbackEvent extends DefaultCallbackEvent {

    @JsonProperty("CorpId")
    private String corpId;

}
