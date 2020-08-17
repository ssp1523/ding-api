package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 客户错误
 *
 * @author: sunshaoping
 * @date: Create by in 10:27 上午 2020/8/13
 */
@Getter
@RequiredArgsConstructor
public enum ClientError implements DingError {

    /**
     * 无
     */
    NOT_FOUND("420001", "客户不存在"),
    /**
     * 无
     */
    QUERY_FAIL("420002", "客户查询失败"),
    /**
     * 无
     */
    CONTACTS_NOT_FOUND("420003", "联系人不存在"),
    /**
     * 无
     */
    CONTACTS_QUERY_FAIL("420004", "联系人查询失败"),
    /**
     * 无
     */
    DELETE_FAIL("420005", "客户删除失败"),
    /**
     * 无
     */
    CONTACTS_DELETE_FAIL("420006", "联系人删除失败"),
    /**
     * 无
     */
    FOLLOWER_BOUND_FAIL("420007", "跟进人绑定失败"),
    /**
     * 无
     */
    ID_ILLEGAL("420008", "客户id非法"),
    /**
     * 无
     */
    FOLLOWER_ID_ILLEGAL("420009", "跟进人id非法"),
    /**
     * 无
     */
    CONTACTS_ID_ILLEGAL("4200010", "客户联系人id非法"),
    /**
     * 无
     */
    DESCRIPTION_NOT_FOUND("4200011", "客户描述表单不存在"),
    /**
     * 无
     */
    DESCRIPTION_QUERY_FAIL("4200012", "客户描述表单查询失败"),
    /**
     * 无
     */
    CONTACTS_DESCRIPTION_NOT_FOUND("4200013", "联系人描述表单不存在"),
    /**
     * 无
     */
    CONTACTS_DESCRIPTION_QUERY_FAIL("4200014", "联系人描述表单查询失败"),
    /**
     * 无
     */
    DESCRIPTION_FORMAT_CHECK("4200015", "客户描述表单格式校验错误"),
    /**
     * 无
     */
    DESCRIPTION_MISSING_FIXED_FIELDS("4200016", "客户描述表单格缺少固定字段"),
    /**
     * 无
     */
    CONTACTS_DESCRIPTION_FORMAT_CHECK("4200017", "客户联系人描述表单格式校验错误"),
    /**
     * 无
     */
    CONTACTS_DESCRIPTION_MISSING_FIXED_FIELDS("4200018", "客户联系人描述表单格缺少固定字段"),
    /**
     * 无
     */
    DESCRIPTION_DATA_FORMAT_CHECK("4200019", "客户描述表单数据格式校验错误"),
    /**
     * 无
     */
    DESCRIPTION_DATA_MISSING_FIXED_FIELDS("4200020", "客户描述表单数据缺少固定字段"),
    /**
     * 无
     */
    CONTACTS_DESCRIPTION_DATA_FORMAT_CHECK("4200021", "客户联系人描述表单数据格式校验错误"),
    /**
     * 无
     */
    CONTACTS_DESCRIPTION_DATA_MISSING_FIXED_FIELDS("4200022", "客户联系人描述表单数据缺少固定字段"),

    ;

    private final String errCode;

    private final String errMsg;


}
