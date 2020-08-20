package com.ssp.ding;

import com.ssp.ding.request.DingDepartmentCreateRequest;
import com.ssp.ding.request.DingDepartmentUpdateRequest;
import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.ssp.ding.response.DingDepartmentResponse;
import org.junit.Test;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * @author: sunshaoping
 * @date: Create by in 11:26 上午 2020/6/9
 */
@Import(RedissonAutoConfiguration.class)
public class DingDepartmentServiceTest extends BaseTest {

    @Autowired
    DingDepartmentService dingDepartmentService;


    @Test
    public void create() {
        Long id = dingDepartmentService.create(
                DingDepartmentCreateRequest.builder()
                        .parentId(1L)
                        .name("产品部")
                        .build()
        );
        //396040352
        System.out.println(id);
    }

    @Test
    public void update() {
        dingDepartmentService.update(
                396040352L,
                DingDepartmentUpdateRequest.builder()
                        .parentId(150239177L)
                        .name("产品部1")
                        .order(1)
                .build()
                );
    }

    @Test
    public void delete() {
    }

    @Test
    public void listIds() {
        List<Long> ids = dingDepartmentService.listIds();
        System.out.println(ids);
    }

    @Test
    public void list() {
        List<DingDepartmentResponse> list = dingDepartmentService.list(1L, false);
        System.out.println(list);
    }

    @Test
    public void get() {
        DingDepartmentDetailResponse detailResponse = dingDepartmentService.get(396040352L);
        System.out.println(detailResponse);
    }

    @Test
    public void listParentDeptsByDept() {
        List<Long> longs = dingDepartmentService.listParentDeptsByDept(396040352L);
        System.out.println(longs);
    }

    @Test
    public void listParentDepts() {
        List<List<Long>> lists = dingDepartmentService.listParentDepts("manager3312");
        System.out.println(lists);

    }
}