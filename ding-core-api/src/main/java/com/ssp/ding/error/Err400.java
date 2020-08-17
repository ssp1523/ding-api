package com.ssp.ding.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 400 开通错误码
 *
 * @author: sunshaoping
 * @date: Create by in 7:09 下午 2020/8/13
 */
@Getter
@RequiredArgsConstructor
public enum Err400 implements DingError {


    /**
     * 无
     */
    CERTIFICATE_TYPE_ILLEGAL("40002", "不合法的凭证类型"),

    /**
     * 确保该id在通讯录中存在，且是在你所传access_token对应的企业里
     */
    USER_ID_ILLEGAL("40003", "不合法的UserID"),
    /**
     * 检查下type字段，只支持 image，voice，file
     */
    MEDIA_TYPE_ILLEGAL("40004", "不合法的媒体文件类型"),
    /**
     * 如果是文件类型，检查下是否是支持。目前只支持doc，docx，xls，xlsx，ppt，pptx，zip，pdf，rar
     */
    FILE_TYPE_ILLEGAL("40005", "不合法的文件类型"),
    /**
     * 检查下文件大小，image类型最大1MB，file类型最大10MB，voice类型最大2MB
     */
    FILE_SIZE_ILLEGAL("40006", "不合法的文件大小"),
    /**
     * 检查下mediaId是否为空，是否真实存在
     */
    MEDIA_ID_ILLEGAL("40007", "不合法的媒体文件id"),
    /**
     * 检查下msgtype是否为空，确保它在开放平台定义的几种类型里，具体见消息类型及格式
     */
    MSG_TYPE_ILLEGAL("40008", "不合法的消息类型"),
    /**
     * 检查下部门id是否为空，是否为数字且大于0
     */
    DEPT_ID_ILLEGAL("40009", "不合法的部门id"),
    /**
     * 检查下父部门id是否为一个数字
     */
    PARENT_ID_ILLEGAL("40010", "不合法的父部门id"),
    /**
     * 检查下order字段是否为空，是否为数字且大于0
     */
    ORDER_ILLEGAL("40011", "不合法的排序order"),
    /**
     * 检查下sender字段是否为空，是否真实存在
     */
    SENDER_ILLEGAL("40012", "不合法的发送者"),
    /**
     * 检查下corpid是否有效
     */
    CORP_ID_ILLEGAL("40013", "不合法的corpid"),
    /**
     * 检查下access_token是否正确，注意access_token这个参数应该是带在url后面的
     */
    ACCESS_TOKEN_ILLEGAL("40014", "不合法的access_token"),
    /**
     * 检查下sender字段和cid字段是否能对应上
     */
    SENDER_NOT_CHAT("40015", "发送者不在会话中"),
    /**
     * 检查下cid字段是否为空，是否有效
     */
    CID_ILLEGAL("40016", "不合法的会话ID"),
    /**
     * cid对应的消息接收者为空，检查下cid字段
     */
    CODE40017("40017", "在会话中没有找到与发送者在同一企业的人"),
    /**
     * 检查下fetchChild字段，目前不支持递归查询
     */
    CODE40018("40018", "不允许以递归方式查询部门用户列表"),
    /**
     * 无
     */
    CODE40019("40019", "该手机号码对应的用户最多可以加入5个非认证企业"),
    /**
     * 无
     */
    CODE40020("40020", "当前团队人数已经达到上限，用电脑登录钉钉企业管理后台，升级成为认证企业"),
    /**
     * 无
     */
    CODE40021("40021", "更换的号码已注册过钉钉，无法使用该号码"),
    /**
     * 无
     */
    CODE40022("40022", "企业中的手机号码和登录钉钉的手机号码不一致，暂时不支持修改用户信息，可以删除后重新添加"),
    /**
     * 部门人数不能超过1000
     */
    CODE40023("40023", "部门人数达到上限"),
    /**
     * 无
     */
    CODE40024("40024", "(安全校验不通过)保存失败，团队人数超限。请在手机钉钉绑定支付宝完成实名认证，或者申请企业认证，人数上限自动扩充"),
    /**
     * 无
     */
    CODE40025("40025", "无效的部门JSONArray对象，合法格式需要用中括号括起来，且如果属于多部门，部门id需要用逗号分隔"),
    /**
     * 无
     */
    OAUTH_CODE_ILLEGAL("40029", "不合法的oauth_code"),
    /**
     * 指定的UserID列表，至少存在一个UserID不在通讯录中
     */
    USER_ID_LIST_ILLEGAL("40031", "不合法的UserID列表"),
    /**
     * 检查下列表是否为空，且长度合适。创建部门接口的userPerimits最多接收10000个
     */
    USER_ID_LENGTH_ILLEGAL("40032", "不合法的UserID列表长度"),
    /**
     * 无
     */
    REQUEST_CHAR_ILLEGAL("40033", "不合法的请求字符，不能包含\\uxxxx格式的字符"),
    /**
     * 检查下有没有传请求参数，一般发生在http post形式的接口里，没有传参数
     */
    PARAM_ILLEGAL("40035", "不合法的参数"),
    /**
     * 检查下参数中是不是少了某个字段，具体参考各个文档的参数介绍
     */
    REQUEST_FORMAT_ILLEGAL("40038", "不合法的请求格式"),
    /**
     * 无
     */
    URL_LENGTH_ILLEGAL("40039", "不合法的URL长度"),
    /**
     * 发消息接口中消息url链接不安全
     */
    DOMAIN_ILLEGAL("40048", "url中包含不合法domain"),

    /**
     * 检查下agentid字段是否为空，是否真实存在
     */
    AGENT_ID_ILLEGAL("40056", "不合法的agentid"),
    /**
     * 无
     */
    CALLBACK_URL_ILLEGAL("40057", "不合法的callbackurl"),
    /**
     * 无
     */
    SETTING_AVATAR_FAIL("40061", "设置应用头像失败"),
    /**
     * 无
     */
    CODE40062("40062", "不合法的应用模式"),
    /**
     * tel字段长度超长，长度不能超过50
     */
    TEL_TOO_LONG_ILLEGAL("40063", "不合法的分机号"),
    /**
     * workPlace长度超长，长度不能超过50个字符
     */
    WORK_PLACE_ILLEGAL("40064", "不合法的工作地址"),
    /**
     * remark长度超长，长度不能超过1024个字符
     */
    REMARK_TOO_LONG_ILLEGAL("40065", "不合法的备注"),
    /**
     * 部门id列表长度太长，不能超过10000，并且每个id必须是数字
     */
    DEPT_ID_LIST_TOO_LONG_ILLEGAL("40066", "不合法的部门列表"),
    /**
     * 检查下标题长度
     */
    TITLE_LENGTH_ILLEGAL("40067", "标题长度不合法"),
    /**
     * 偏移量必须大于0
     */
    OFFSET_ILLEGAL("40068", "不合法的偏移量"),
    /**
     * 分页大小不合法，具体参考每个接口的参数定义
     */
    PAGE_SIZE_ILLEGAL("40069", "不合法的分页大小"),
    /**
     * 具体参考获取部门成员接口里面对order字段的定义
     */
    DEPT_ORDER_ILLEGAL("40070", "不合法的排序参数"),
    /**
     * openid不能为空
     */
    OPEN_ID_ILLEGAL("40073", "不存在的openid"),
    /**
     * 无
     */
    PRE_AUTH_CODE_NOT_EXIST("40077", "不存在的预授权码"),
    /**
     * 临时授权码不能为空，且只能被使用一次
     */
    TEMPORARY_AUTH_CODE_NOT_EXIST("40078", "不存在的临时授权码"),
    /**
     * 检查下企业是否授权，授权方法参考文档
     */
    AUTH_INFO_NOT_EXIST("40079", "不存在的授权信息"),
    /**
     * 无
     */
    SUITE_SECRET_ILLEGAL("40080", "不合法的suitesecret"),
    /**
     * 检查下token
     */
    SUITE_TOKEN_ILLEGAL("40082", "不合法的suitetoken"),
    /**
     * suiteKey字段不合法
     */
    SUITE_ID_ILLEGAL("40083", "不合法的suiteid"),
    /**
     * 检查下永久授权码是否正确
     */
    PERMANENT_AUTH_CODE_ILLEGAL("40084", "不合法的永久授权码"),
    /**
     * 检查下suiteticket是否正确，确保是由回调接口正确来接收suiteticket
     */
    SUITE_TICKET_NOT_EXIST("40085", "不存在的suiteticket"),
    /**
     * appid字段不能为空
     */
    THIRD_PART_APP_ID_ILLEGAL("40086", "不合法的第三方应用appid"),
    /**
     * 稍后再重试下，确保参数都传对
     */
    CREATE_PERMANENT_AUTH_CODE_FAIL("40087", "创建永久授权码失败"),
    /**
     * 稍后再重试下，确保suiteKey和suiteSecret都传对且一一对应
     */
    KEY_SECRET_ILLEGAL("40088", "不合法的套件key或secret"),
    /**
     * 如果你使用的是corpsecret，请稍后再重试下，确保corpid和corpsecret字段传对且一一对应。
     */
    CODE40089("40089", "不合法的corpid或corpsecret或者不合法的appkey或appsecret"),

    /**
     * 检查下suiteKey字段是否正确
     */
    SUITE_KEY_NOT_EXIST("40090", "套件已经不存在"),
    /**
     * 创建永久授权码失败，需要用户重新授权产生临时授权码
     */
    USER_AUTH_CODE_CREATE_FAIL("40091", "用户授权码创建失败，需要用户重新授权"),
    ;

    private final String errCode;

    private final String errMsg;


}
