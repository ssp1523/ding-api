package com.ssp.ding.error;

import java.util.Objects;

/**
 * 错误代码,请使用枚举类实现该接口
 *
 * @author: sunshaoping
 * @date: Create by in 09:47 2019-09-20
 */
public interface DingError {


    /**
     * 错误代码
     */
    String getErrCode();

    /**
     * 错误描述
     */
    String getErrMsg();

    /**
     * 错误码是否相等
     *
     * @see #getErrCode()
     */
    default boolean eqErrCode(DingError dingError) {
        return Objects.equals(getErrCode(), dingError.getErrCode());
    }

    /**
     * 错误码是否相等
     */
    default boolean eqErrCode(String errCode) {
        return Objects.equals(getErrCode(), errCode);
    }

}
