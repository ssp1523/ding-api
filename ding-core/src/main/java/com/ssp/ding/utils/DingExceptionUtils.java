package com.ssp.ding.utils;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.error.DingError;
import com.ssp.ding.error.SysError;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoResponse;

/**
 * DingException 异常构建
 *
 * @author: sunshaoping
 * @date: Create by in 5:56 下午 2020/8/12
 */
public final class DingExceptionUtils {


    private DingExceptionUtils() { }


    public static DingException of(DingError dingError) {
        return new DingException(dingError.getErrCode(), dingError.getErrMsg())
                .setSource(dingError);
    }

    public static DingException of(TaobaoResponse response) {
        if (SysError.AUTHENTICATION.eqErrCode(response.getErrorCode())) {
            // 使用子错误码
            // 如果最外层errcode = 88，表示请求失败，需要关注下返回结果里的sub_code和sub_msg。
            // 此类情况下，一般是用户的access_token不合法或者没有调用该接口的权限。
            return new DingException(response.getSubCode(), response.getSubMsg())
                    .setSource(response);
        }

        return new DingException(response.getErrorCode(), response.getMsg())
                .setSource(response);
    }

    public static DingException of(ApiException e) {
        if (SysError.AUTHENTICATION.eqErrCode(e.getErrCode())) {
            // 使用子错误码
            // 如果最外层errcode = 88，表示请求失败，需要关注下返回结果里的sub_code和sub_msg。
            // 此类情况下，一般是用户的access_token不合法或者没有调用该接口的权限。
            throw new DingException(e.getSubErrCode(), e.getSubErrMsg() + "," + e.getMessage(), e)
                    .setSource(e);
        }
        throw new DingException(e.getErrCode(), e.getErrMsg() + "," + e.getMessage(), e)
                .setSource(e);
    }


}
