package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 通讯录错误
 *
 * @author: sunshaoping
 * @date: Create by in 10:16 上午 2020/8/13
 */
@Getter
@RequiredArgsConstructor
public enum ContactsError implements DingError {

    /**
     * 检查参数roleName、groupId是否正确
     */
    ROLE_INFO_NOT_NULL("34018", "角色信息不能为空"),

    /**
     * 请检查userid是否正确，可以打开OA管理后台-通讯录-打开用户通讯录-名称右侧员工UserID查看
     */
    INVALID_USER_ID("33012", "无效的UserID"),


    /**
     * 无
     */
    USER_ID_IN_CORP_EXIST("60102", "UserID在公司中已存在"),

    /**
     * 无
     */
    PHONE_ILLEGAL("60103", "手机号码不合法"),
    /**
     * 无
     */
    PHONE_IN_CORP_EXIST("60104", "手机号码在公司中已存在"),
    /**
     * 无
     */
    EMAIL_ILLEGAL("60105", "邮箱不合法"),
    /**
     * 无
     */
    EMAIL_EXIST("60106", "邮箱已存在"),
    /**
     * 无
     */
    PHONE_LOGIN_DING_USER_IN_CORP("60107", "使用该手机登录钉钉的用户已经在企业中"),
    /**
     * 无
     */
    DEPT_COUNT_LIMIT_EXCEEDED("60110", "部门个数超出限制"),
    /**
     * 无
     */
    USER_ID_NOT_EXIST("60111", "UserID不存在"),
    /**
     * 无
     */
    USER_NAME_ILLEGAL("60112", "用户name不合法"),
    /**
     * 无
     */
    IDENTITY_AUTH_NOT_SIMULTANEOUSLY_NULL("60113", "身份认证信息（手机/邮箱）不能同时为空"),
    /**
     * 无
     */
    GENDER_ILLEGAL("60114", "性别不合法"),
    /**
     * 无
     */
    USER_INACTIVE_INVITE_FIELD("60118", "用户无有效邀请字段（邮箱，手机号）"),
    /**
     * 无
     */
    POSITION_ILLEGAL("60119", "不合法的position"),
    /**
     * 无
     */
    USER_DISABLED("60120", "用户已禁用"),
    /**
     * 检查该企业下该员工是否存在
     */
    USER_NOT_FOUND("60121", "找不到该用户"),
    /**
     * 无
     */
    EXT_ATTR_ILLEGAL("60122", "不合法的extattr"),
    /**
     * 无
     */
    JOB_NUMBER_ILLEGAL("60123", "不合法的jobnumber"),


    ;
    private final String errCode;

    private final String errMsg;

}
