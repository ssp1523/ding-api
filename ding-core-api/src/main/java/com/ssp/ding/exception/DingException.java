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

    public DingException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public DingException(String message, Throwable e) {
        this(null, message, e);
    }

    public DingException(String errCode, String message, Throwable e) {
        super(message, e);
        this.errCode = errCode;
    }

}
