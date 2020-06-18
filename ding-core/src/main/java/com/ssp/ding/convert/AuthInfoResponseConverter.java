package com.ssp.ding.convert;

import com.ssp.ding.response.AuthInfoResponse;
import com.dingtalk.api.response.OapiServiceGetAuthInfoResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * 认证响应信息 转换
 *
 * @author: sunshaoping
 * @date: Create by in 5:33 下午 2020/6/7
 */
public class AuthInfoResponseConverter implements Converter<OapiServiceGetAuthInfoResponse, AuthInfoResponse> {


    @Override
    public AuthInfoResponse convert(OapiServiceGetAuthInfoResponse source) {
        return new AuthInfoResponse();
    }
}
