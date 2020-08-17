package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 微应用错误
 *
 * @author: sunshaoping
 * @date: Create by in 7:05 下午 2020/8/12
 * @see SysError
 */
@Getter
@RequiredArgsConstructor
public enum MiniAppError implements DingError {
    /**
     * 请确认下access_token是否正确
     */
    INVALID_CORP_ID("33001", "无效的企业ID"),
    /**
     * 校验下微应用的名称字段，不能为空且长度不能超过10个字符
     */
    INVALID_NAME("33002", "无效的微应用的名称"),
    /**
     * 校验下微应用的描述字段，不能为空且长度不能超过20个字符
     */
    INVALID_DESCRIPTION("33003", "无效的微应用的描述"),
    /**
     * 校验下微应用的ICON字段，不能为空且确保图标存在
     */
    INVALID_ICON("33004", "无效的微应用的ICON"),
    /**
     * 校验下微应用的移动端主页，不能为空且必须以HTTP开头或HTTPS开头
     */
    INVALID_MOBILE_HOMEPAGE("33005", "无效的微应用的移动端主页"),
    /**
     * 校验下微应用的PC端主页，必须以HTTP开头或HTTPS开头
     */
    INVALID_PC_HOMEPAGE("33006", "无效的微应用的PC端主页"),
    /**
     * 校验下微应用的PC端主页，确保它和移动端主页的域名保持一致
     */
    MINI_APP__MOBILE_PC_HOMEPAGE_DIFFERENT("33007", "微应用的移动端的主页与PC端主页不同"),
    /**
     * 校验下微应用的后台管理的主页失败，必须以HTTP开头或HTTPS开头
     */
    INVALID_OA_HOMEPAGE("33008", "无效的微应用OA后台的主页"),

    ;

    private final String errCode;

    private final String errMsg;

}
