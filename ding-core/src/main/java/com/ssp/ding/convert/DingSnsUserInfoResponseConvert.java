package com.ssp.ding.convert;

import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.ssp.ding.response.DingSnsUserInfoResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * DingSnsUserInfoResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 5:54 下午 2020/8/17
 */
public class DingSnsUserInfoResponseConvert implements Converter<OapiSnsGetuserinfoBycodeResponse.UserInfo, DingSnsUserInfoResponse> {

    @Override
    public DingSnsUserInfoResponse convert(OapiSnsGetuserinfoBycodeResponse.UserInfo userInfo) {
        return DingSnsUserInfoResponse.builder()
                .nick(userInfo.getNick())
                .openId(userInfo.getOpenid())
                .unionId(userInfo.getUnionid())
                .build();
    }
}
