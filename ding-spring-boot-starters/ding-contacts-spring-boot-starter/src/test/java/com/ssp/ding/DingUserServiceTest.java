package com.ssp.ding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.enumeration.OnlyActive;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingUserRequest;
import com.ssp.ding.response.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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


    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void create() {

        CharSequence userId = dingUserService.create(
                DingUserRequest.builder()
                        .department(Collections.singletonList(150239177L))
                        .name("张无忌")
                        .mobile("13388996655")
                        .email("123@qq.com")
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
        DingUserResponse response = dingUserService.get("manager3312");
        System.out.println(objectMapper.writeValueAsString(response));

    }

    @Test
    public void getDeptMember() {
        List<String> deptMember = dingUserService.getDeptMember(150239177L);
        System.out.println(deptMember);
    }

    @Test
    public void simpleList() throws JsonProcessingException {
        DingPage<DingUserSimpleResponse> dingUserSimpleResponses = dingUserService.simpleList(150239177L);
        System.out.println(objectMapper.writeValueAsString(dingUserSimpleResponses));

    }

    @Test
    public void listByPage() throws JsonProcessingException {
        DingPage<DingUserListResponse> dingUserResponses =
                dingUserService.listByPage( DingPageable.builder()
                .size(2)
                .offset(2)
                .build(),
                150239177L);
        System.out.println(objectMapper.writeValueAsString(dingUserResponses));

    }

    @Test
    public void getAdmin() throws JsonProcessingException {
        List<AdminResponse> admin = dingUserService.getAdmin();
        System.out.println(objectMapper.writeValueAsString(admin));

    }

    @Test
    public void getAdminScope() {
        List<Long> list = dingUserService.getAdminScope("manager3312");
        System.out.println(list);
    }


    @Test
    public void getUserIdByUnionId() {
        UserIdResponse userIdResponse = dingUserService.getUserIdByUnionId("FlB5SPbb5uGgbhgbz5ChVgiEiE");
        System.out.println(userIdResponse.getContactType() + "," + userIdResponse.getUserId());
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
        DingPage<String> page = dingUserService.getInactive(LocalDate.now().minusDays(10));
        System.out.println(page.getContent());
    }
}