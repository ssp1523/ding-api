package com.ssp.ding.exception;

import com.ssp.ding.error.DingError;
import lombok.Getter;

import javax.annotation.Nullable;

/**
 * 钉钉异常信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:57 下午 2020/6/7
 */
@Getter
public class DingException extends RuntimeException implements DingError {

    private final String errCode;

    private final String errMsg;

    /**
     * 异常元数据
     */
    private Object source;

    public DingException(String errCode, String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public DingException(String errMsg, Throwable e) {
        this(null, errMsg, e);
    }

    public DingException(String errCode, String errMsg, Throwable e) {
        super(errMsg, e);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public String getMessage() {
        return "错误码:" + errCode + ",错误原因:" + super.getMessage();
    }

    public DingException setSource(Object source) {
        this.source = source;
        return this;
    }

    /**
     * 异常元数据
     */
    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T getSource() {
        return (T) source;
    }
}
