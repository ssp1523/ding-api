package com.ssp.ding.service;

import com.ssp.ding.BaseTest;
import com.ssp.ding.enumeration.OnlyActive;
import com.ssp.ding.request.DingUserRequest;
import com.ssp.ding.response.AdminResponse;
import com.ssp.ding.response.DingUserResponse;
import com.ssp.ding.response.DingUserSimpleResponse;
import com.ssp.ding.response.UserIdResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author: sunshaoping
 * @date: Create by in 3:50 下午 2020/6/8
 */
public class DingUserServiceTest extends BaseTest {

    @Autowired
    DingUserService dingUserService;

    ObjectMapper objectMapper = new ObjectMapper();
    {
        objectMapper.registerModule(new Jdk8Module());
    }


    @Test
    public void create() {

        CharSequence userId = dingUserService.create(
                DingUserRequest.builder()
                        .departments(Collections.singletonList(150239177L))
                        .name("张无忌")
                        .mobile("13388996655")
                        .build()
        );
        System.out.println(userId);
    }

    @Test
    public void update() {
        dingUserService.update("184514323424235276",
                DingUserRequest.builder()
                        .name("张无忌2")
                        .jobNumber("1002")
                        .build()
        );
    }

    @Test
    public void delete() {
        dingUserService.delete("184514323424235276");
    }

    @Test
    public void getUser() throws JsonProcessingException {
        DingUserResponse response = dingUserService.getUser("manager1402");
        System.out.println(objectMapper.writeValueAsString(response));

    }

    @Test
    public void getDeptMember() {
        List<String> deptMember = dingUserService.getDeptMember(150239177L);
        System.out.println(deptMember);
    }

    @Test
    public void simpleList() throws JsonProcessingException {
        Page<DingUserSimpleResponse> dingUserSimpleResponses = dingUserService.simpleList(PageRequest.of(0, 10), 82233094L);
        System.out.println(objectMapper.writeValueAsString(dingUserSimpleResponses));

    }

    @Test
    public void listByPage() throws JsonProcessingException {
        Page<DingUserResponse> dingUserResponses = dingUserService.listByPage(PageRequest.of(0, 10), 82233094L);
        System.out.println(objectMapper.writeValueAsString(dingUserResponses));

    }

    @Test
    public void getAdmin() throws JsonProcessingException {
        List<AdminResponse> admin = dingUserService.getAdmin();
        System.out.println(objectMapper.writeValueAsString(admin));

    }

    @Test
    public void getAdminScope() {
        List<Long> list = dingUserService.getAdminScope("manager1402");
        System.out.println(list);
    }


    @Test
    public void getUserIdByUnionId() {
        UserIdResponse userIdResponse = dingUserService.getUserIdByUnionId("KtRAiPhAeK4f6tEEbNOLjuwiEiE");
        System.out.println(userIdResponse.getContactType()+","+userIdResponse.getUserId());
    }

    @Test
    public void getByMobile() {
        CharSequence userId = dingUserService.getByMobile("15001137022");
        System.out.println(userId);
    }

    @Test
    public void getOrgUserCount() {
        Long count = dingUserService.getOrgUserCount(OnlyActive.NOT_ACTIVE);
        System.out.println(count);
    }

    @Test
    public void getInactive() {
        Page<String> page = dingUserService.getInactive(PageRequest.of(0, 10), LocalDate.now().minusDays(1));
        System.out.println(page.getContent());
    }
}