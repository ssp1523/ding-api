package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 管理员
 *
 * @author: sunshaoping
 * @date: Create by in 3:55 下午 2020/6/7
 */
@Data
@Builder
public class AdminResponse {

    private String adminMobile;

    private Long sysLevel;

    private String userId;
}
