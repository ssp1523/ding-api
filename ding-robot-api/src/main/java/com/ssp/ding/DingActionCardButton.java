package com.ssp.ding;

import lombok.Builder;
import lombok.Getter;

/**
 * 按钮
 *
 * @author: sunshaoping
 * @date: Create by in 3:03 下午 2020/7/21
 */
@Getter
@Builder
public class DingActionCardButton {
    /**
     * 按钮标题
     */
    private final String title;
    /**
     * 点击按钮触发的URL
     */
    private final String actionURL;
}
