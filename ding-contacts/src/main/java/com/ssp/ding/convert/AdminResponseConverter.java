package com.ssp.ding.convert;

import com.dingtalk.api.response.OapiUserGetAdminResponse;
import com.ssp.ding.response.AdminResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
public class AdminResponseConverter implements Converter<OapiUserGetAdminResponse.AdminList, AdminResponse> {

    @Override
    public AdminResponse convert(OapiUserGetAdminResponse.AdminList adminList) {
        return AdminResponse.builder()
                .adminMobile(adminList.getAdminMobile())
                .sysLevel(adminList.getSysLevel())
                .userId(adminList.getUserid())
                .build();
    }
}
