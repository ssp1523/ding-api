package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 用户简单信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:51 下午 2020/6/7
 */
@Data
@Builder
public class DingUserSimpleResponse {

    private String name;

    private String userId;

}
