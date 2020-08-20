package com.ssp.ding.convert;

import com.dingtalk.api.response.OapiUserSimplelistResponse;
import com.ssp.ding.response.DingUserSimpleResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * @see DingUserSimpleResponse
 *
 * @author: sunshaoping
 * @date: Create by in 11:42 上午 2020/6/8
 */
public class DingUserSimpleResponseConverter implements Converter<OapiUserSimplelistResponse.Userlist,DingUserSimpleResponse> {

    @Override
    public DingUserSimpleResponse convert(OapiUserSimplelistResponse.Userlist userList) {
        return DingUserSimpleResponse.builder()
                .name(userList.getName())
                .userId(userList.getUserid())
                .build();
    }
}
