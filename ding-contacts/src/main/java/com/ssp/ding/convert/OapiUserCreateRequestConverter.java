package com.ssp.ding.convert;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.dingtalk.api.request.OapiUserCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * OapiUserCreateRequest
 *
 * @author: sunshaoping
 * @date: Create by in 4:01 下午 2020/6/8
 */
@Slf4j
@RequiredArgsConstructor
public class OapiUserCreateRequestConverter implements Converter<DingUserRequest, OapiUserCreateRequest> {

    private final ObjectMapper objectMapper;

    @Override
    public OapiUserCreateRequest convert(DingUserRequest dingUserRequest) {
        //Assert.notBlank(dingUserRequest.getName(), "name必输");
        //Assert.notEmpty(dingUserRequest.getDepartment(), "departments必输");
        //Assert.notEmpty(dingUserRequest.getMobile(), "mobile必输");
        OapiUserCreateRequest request = new OapiUserCreateRequest();

        try {
            request.setDepartment(objectMapper.writeValueAsString(dingUserRequest.getDepartment()));
            if (MapUtil.isNotEmpty(dingUserRequest.getExtAttr())) {
                request.setExtattr(objectMapper.writeValueAsString(dingUserRequest.getExtAttr()));
            }

            if (MapUtil.isNotEmpty(dingUserRequest.getOrderInDepts())) {
                request.setOrderInDepts(objectMapper.writeValueAsString(dingUserRequest.getOrderInDepts()));
            }
        } catch (JsonProcessingException e) {
            log.error("序列化失败,{}", e.getMessage(), e);
            throw new DingException(e.getMessage(), e);
        }
        if (ObjectUtil.isNotEmpty(dingUserRequest.getHiredDate())) {
            Instant instant = LocalDateTime.of(dingUserRequest.getHiredDate(), LocalTime.MIN).toInstant(ZoneOffset.ofHours(8));
            request.setHiredDate(instant.toEpochMilli());
        }
        request.setEmail(dingUserRequest.getEmail());
        request.setIsHide(dingUserRequest.getIsHide());
        request.setIsSenior(dingUserRequest.getIsSenior());
        request.setJobnumber(dingUserRequest.getJobNumber());
        request.setMobile(dingUserRequest.getMobile());
        request.setName(dingUserRequest.getName());
        request.setOrgEmail(dingUserRequest.getOrgEmail());
        request.setPosition(dingUserRequest.getPosition());
        request.setRemark(dingUserRequest.getRemark());
        request.setTel(dingUserRequest.getTel());
        request.setUserid(dingUserRequest.getUserId());
        request.setWorkPlace(dingUserRequest.getWorkPlace());

        return request;
    }
}
