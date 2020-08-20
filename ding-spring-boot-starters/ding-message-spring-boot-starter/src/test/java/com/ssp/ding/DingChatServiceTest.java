package com.ssp.ding;

import com.ssp.ding.enumeration.MediaType;
import com.ssp.ding.request.DingChatCreateRequest;
import com.ssp.ding.request.DingChatUpdateRequest;
import com.ssp.ding.response.DingMediaResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.util.Collections;

/**
 *
 *
 * @author: sunshaoping
 * @date: Create by in 6:14 下午 2020/7/1
 */
public class DingChatServiceTest extends BaseTest{

    @Autowired
    DingChatService dingChatService;

    @Autowired
    DingMediaService dingMediaService;

    @Test
    public void create() {

        //创建群
        dingChatService.create(
                DingChatCreateRequest.builder()
                        .name("沙雕群")
                        .owner("manager3312")
                        .userIdList(Collections.singletonList("184514323424235276"))
                        .build()
        );
    }

    @Test
    public void update() {
        dingChatService.update("chat88f58dc3431ec87089e414642579f3a3",
                DingChatUpdateRequest.builder()
                        .icon("http://img.jj20.com/up/allimg/tx13/082120191238.jpg")
                .build()
                );
    }

    @Test
    public void upload() {
        ClassPathResource classPathResource = new ClassPathResource("admin.png");

        DingMediaResponse response = dingMediaService.upload(MediaType.IMAGE, classPathResource);

        dingChatService.update("chat88f58dc3431ec87089e414642579f3a3",
                DingChatUpdateRequest.builder()
                        .icon(response.getMediaId())
                        .build()
        );
    }
}
