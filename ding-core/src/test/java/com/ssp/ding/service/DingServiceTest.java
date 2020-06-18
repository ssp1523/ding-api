package com.ssp.ding.service;

import com.ssp.ding.DingService;
import com.ssp.ding.DingSpringBootStarterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author: sunshaoping
 * @date: Create by in 3:20 下午 2020/6/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DingSpringBootStarterApplication.class)
public class DingServiceTest {

    @Autowired
    DingService dingService;

    @Test
    public void getAccessToken() {
        CharSequence accessToken = dingService.getAccessToken();
        System.out.println(accessToken);
    }

    @Test
    public void refreshAccessToken() {
    }
}