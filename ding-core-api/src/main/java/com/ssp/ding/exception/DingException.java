package com.ssp.ding.exception;

import lombok.Getter;

/**
 * 钉钉异常信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:57 下午 2020/6/7
 */
@Getter
public class DingException extends RuntimeException {

    private final String errCode;

    private final String errMsg;


    public DingException(String errCode, String errMsg) {
        this(errCode, errMsg, errMsg);
    }

    public DingException(String message, Throwable e) {
        this(null, null, message, e);
    }

    public DingException(String errCode, String errMsg, String message) {
        super(message);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public DingException(String errCode, String errMsg, String message, Throwable e) {
        super(message, e);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}
