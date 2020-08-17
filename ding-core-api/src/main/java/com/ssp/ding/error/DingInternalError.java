package com.ssp.ding.error;

import com.ssp.ding.exception.DingInternalException;

import java.text.MessageFormat;

/**
 * 框架内部错误,不在钉钉接口范围的错误码
 *
 * @author: sunshaoping
 * @date: Create by in 10:06 上午 2020/8/17
 */
public interface DingInternalError extends DingError {


    default String format(Object... args) {
        return MessageFormat.format(this.getErrMsg(), args);
    }

    /**
     * 返回 DingInternalException 异常
     *
     * @see DingInternalException
     */
    default DingInternalException internalException(Object... args) {
        return new DingInternalException(getErrCode(), format(args));
    }
}
