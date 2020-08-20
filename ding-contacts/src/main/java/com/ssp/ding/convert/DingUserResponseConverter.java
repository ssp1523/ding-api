package com.ssp.ding.convert;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.conf.TypeReferenceConf;
import com.ssp.ding.response.DingRole;
import com.ssp.ding.response.DingUserResponse;
import com.ssp.ding.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
@RequiredArgsConstructor
public class DingUserResponseConverter implements Converter<OapiUserGetResponse, DingUserResponse> {

    private final ObjectMapper objectMapper;

    @Override
    public DingUserResponse convert(OapiUserGetResponse response) {

        return DingUserResponse.builder()
                .active(response.getActive())
                .department(response.getDepartment())
                .avatar(response.getAvatar())
                .email(response.getEmail())
                .extAttr(createExtAttr(response.getExtattr()))
                .hiredDate(DateUtils.toLocalDate(response.getHiredDate()))
                .isAdmin(response.getIsAdmin())
                .isBoss(response.getIsBoss())
                .isHide(response.getIsHide())
                .isLeaderInDepts(createIsLeaderInDepts(response.getIsLeaderInDepts()))
                .isSenior(response.getIsSenior())
                .jobNumber(response.getJobnumber())
                .mobile(response.getMobile())
                .name(response.getName())
                .orderInDepts(createOrderInDepts(response.getOrderInDepts()))
                .orgEmail(response.getOrgEmail())
                .position(response.getPosition())
                .remark(response.getRemark())
                .roles(createDingRoles(response.getRoles()))
                .stateCode(response.getStateCode())
                .tel(response.getTel())
                .unionId(response.getUnionid())
                .userId(response.getUserid())
                .workPlace(response.getWorkPlace())
                .build();
    }

    private Map<Long, Long> createOrderInDepts(String orderInDepts) {
        return parseJson(orderInDepts, "orderInDepts", TypeReferenceConf.MAP_LONG_LONG);
    }

    private <K, V> Map<K, V> parseJson(String json, String property, TypeReference<Map<K, V>> valueTypeRef) {
        try {
            if (StrUtil.isBlank(json)) {
                return Collections.emptyMap();
            }
            return objectMapper.readValue(json, valueTypeRef);
        } catch (IOException e) {
            log.error("解析{}失败,{}", property, e.getMessage(), e);
            return Collections.emptyMap();
        }
    }

    private Map<Long, Boolean> createIsLeaderInDepts(String isLeaderInDepts) {
        return parseJson(isLeaderInDepts, "isLeaderInDepts", TypeReferenceConf.MAP_LONG_BOOLEAN);

    }

    private Map<String, String> createExtAttr(String extAttr) {
        return parseJson(extAttr, "extattr", TypeReferenceConf.MAP_STRING_STRING);
    }

    private List<DingRole> createDingRoles(List<OapiUserGetResponse.Roles> roles) {
        if (CollUtil.isEmpty(roles)) {
            return Collections.emptyList();
        }
        return roles.stream()
                .map(role ->
                        DingRole.builder()
                                .id(role.getId())
                                .groupName(role.getGroupName())
                                .name(role.getName())
                                .build())
                .collect(Collectors.toList());

    }
}
