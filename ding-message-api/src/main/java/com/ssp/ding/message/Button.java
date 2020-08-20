package com.ssp.ding.message;

import lombok.Builder;
import lombok.Getter;

/**
 * 按钮信息
 *
 * @author: sunshaoping
 * @date: Create by in 10:17 上午 2020/6/16
 */
@Builder
@Getter
public class Button {
    /**
     * 使用独立跳转ActionCard样式时的按钮的标题，最长20个字符
     */
    private final String title;
    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接，最长500个字符
     */
    private final String actionUrl;
}
