package com.ssp.ding.exception;

import com.ssp.ding.error.DingInternalError;
import lombok.Getter;

/**
 * 框架内部异常信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:57 下午 2020/6/7
 */
@Getter
public class DingInternalException extends DingException implements DingInternalError {


    public DingInternalException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public DingInternalException(String errMsg, Throwable e) {
        super(errMsg, e);
    }

    public DingInternalException(String errCode, String errMsg, Throwable e) {
        super(errCode, errMsg, e);
    }
}
