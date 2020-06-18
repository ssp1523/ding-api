package com.ssp.ding.service;

import com.ssp.ding.BaseTest;
import com.ssp.ding.request.DingDepartmentCreateRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: sunshaoping
 * @date: Create by in 11:26 上午 2020/6/9
 */
public class DingDepartmentServiceTest extends BaseTest {

    @Autowired
    DingDepartmentService dingDepartmentService;

    @Test
    public void create() {
        dingDepartmentService.create(
                DingDepartmentCreateRequest.builder()
                        .name("开发部")
                        .build()
        );
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void listIds() {
    }

    @Test
    public void list() {
    }

    @Test
    public void get() {
    }

    @Test
    public void listParentDeptsByDept() {
    }

    @Test
    public void listParentDepts() {
        List<List<Long>> lists = dingDepartmentService.listParentDepts("142247654023227803");
        System.out.println(lists);

    }
}