package com.ssp.ding.service;

import com.ssp.ding.DingService;
import org.junit.Test;

/**
 *
 * @author: sunshaoping
 * @date: Create by in 3:20 下午 2020/6/8
 */
public class DingServiceTest {

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