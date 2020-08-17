package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 群消息错误
 *
 * @author: sunshaoping
 * @date: Create by in 10:00 上午 2020/8/13
 */
@Getter
@RequiredArgsConstructor
public enum ChatError implements DingError {

    /**
     * 检查下所传的chatId字段是否为空
     */
    INVALID__ID("34001", "无效的会话id"),
    /**
     * 检查下sender字段是否为空
     */
    INVALID_MESSAGE_SENDER("34002", "无效的会话消息的发送者"),
    /**
     * 检查下发送者的企业Id
     */
    INVALID_SENDER_CORP_ID("34003", "无效的会话消息的发送者的企业Id"),
    /**
     * 检查下msgtype字段，是否为空，是否是定义的类型
     */
    INVALID_MESSAGE_TYPE("34004", "无效的会话消息的类型"),
    /**
     * 检查下发送者是否在企业中
     */
    SENDER_NOT_IN_CORP("34006", "发送者不在企业中"),
    /**
     * 检查下发送者是否在会话id中
     */
    SENDER_NOT_IN_SESSION("34007", "发送者不在会话中"),
    /**
     * 如果发的是图片消息，检查下图片是否为空
     */
    IMAGE_NOT_NULL("34008", "图片不能为空"),
    /**
     * 检查下messageUrl字段是否为空
     */
    LINK_NOT_NULL("34009", "链接内容不能为空"),
    /**
     * 检查下media_id字段是否为空
     */
    FILE_NOT_NULL("34010", "文件不能为空"),
    /**
     * 检查下media_id字段是否为空
     */
    MEDIA_ID_NOT_NULL("34011", "音频文件不能为空"),
    /**
     * 检查下发送者是否是真实的
     */
    NOT_FOUND_SENDER_CORP("34012", "找不到发送者的企业"),
    /**
     * 检查下chatid是否真实存在
     */
    NOT_FOUND_CHAT("34013", "找不到群会话对象"),
    /**
     * 检查下消息的json格式是否正确，json的key对应msgtype的value值
     */
    INVALID_JSON("34014", "会话消息的json结构无效或不完整"),
    /**
     * 消息发送失败，建议稍后再重试下
     */
    SENDER_CHAT_FAIL("34015", "发送群会话消息失败"),
    /**
     * 检查下消息的content字段长度是否超过5000，title字段长度是否超过64，markdown字段长度是否超过5000，single_title字段长度是否超过20，single_url字段长度是否超过500，btn_json_list字段长度是否超过1000
     */
    CONTENT_TOO_LONG("34016", "消息内容长度超过限制"),


    /**
     * 无
     */
    USER_NOT_CHAT("60124", "用户不在此群中"),
    ;
    private final String errCode;

    private final String errMsg;

}
