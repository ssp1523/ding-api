package com.ssp.ding.convert;

import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.response.OapiUserListbypageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.conf.TypeReferenceConf;
import com.ssp.ding.response.DingUserListResponse;
import com.ssp.ding.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
@RequiredArgsConstructor
public class DingUserListResponseConverter implements Converter<OapiUserListbypageResponse.Userlist, DingUserListResponse> {

    private final ObjectMapper objectMapper;

    @Override
    public DingUserListResponse convert(OapiUserListbypageResponse.Userlist response) {
        return DingUserListResponse.builder()
                .active(response.getActive())
                .department(response.getDepartment())
                .avatar(response.getAvatar())
                .email(response.getEmail())
                .extAttr(createExtAttr(response.getExtattr()))
                .hiredDate(DateUtils.toLocalDate(response.getHiredDate()))
                .isAdmin(response.getIsAdmin())
                .isBoss(response.getIsBoss())
                .isHide(response.getIsHide())
                .jobNumber(response.getJobnumber())
                .mobile(response.getMobile())
                .name(response.getName())
                .orgEmail(response.getOrgEmail())
                .position(response.getPosition())
                .remark(response.getRemark())
                .tel(response.getTel())
                .unionId(response.getUnionid())
                .userId(response.getUserid())
                .workPlace(response.getWorkPlace())
                .isLeader(response.getIsLeader())
                .order(response.getOrder())
                .build();
    }


    private Map<String, String> createExtAttr(String extAttr) {
        try {
            if (StrUtil.isBlank(extAttr)) {
                return Collections.emptyMap();
            }
            return objectMapper.readValue(extAttr, TypeReferenceConf.MAP_STRING_STRING);
        } catch (IOException e) {
            log.error("解析{}失败,{}", extAttr, e.getMessage(), e);
            return Collections.emptyMap();
        }
    }


}
