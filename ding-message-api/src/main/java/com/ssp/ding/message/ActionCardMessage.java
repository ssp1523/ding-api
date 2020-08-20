package com.ssp.ding.message;

import com.ssp.ding.enumeration.MsgType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 卡片消息
 *
 * @author: sunshaoping
 * @date: Create by in 7:40 下午 2020/6/15
 */
@Builder
@Getter
public class ActionCardMessage extends DingMessage {


    /**
     * 透出到会话列表和通知的文案，最长64个字符
     */
    private final String title;
    /**
     * 消息内容，支持markdown，语法参考标准markdown语法。建议1000个字符以内
     */
    private final String markdown;
    /**
     * 使用整体跳转ActionCard样式时的标题，必须与single_url同时设置，最长20个字符
     */
    private final String singleTitle;
    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接，最长500个字符
     */
    private final String singleUrl;

    /**
     * 使用独立跳转ActionCard样式时的按钮排列方式，竖直排列(0)，横向排列(1)；必须与btn_json_list同时设置
     */
    private final String btnOrientation;
    /**
     * 使用独立跳转ActionCard样式时的按钮列表；必须与btn_orientation同时设置
     */
    private final List<Button> btnJsonList;

    @Override
    public MsgType getMsgType() {
        return MsgType.ACTION_CARD;
    }

}
