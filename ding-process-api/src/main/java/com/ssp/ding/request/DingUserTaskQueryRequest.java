package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

/**
 * @author: sunshaoping
 * @date: Create by in 4:03 下午 2020/6/17
 */
@Getter
@Builder
public class DingUserTaskQueryRequest {

    /**
     * 0表示待处理，-1表示已经移除
     */
    private final Integer status;
    /**
     * 用户id
     */
    private final String userId;

}
