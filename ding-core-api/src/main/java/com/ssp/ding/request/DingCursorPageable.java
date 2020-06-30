package com.ssp.ding.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 钉钉分页请求
 *
 * @author: sunshaoping
 * @date: Create by in 4:20 下午 2020/6/17
 */
@Getter
@RequiredArgsConstructor
public class DingCursorPageable {

    public static final DingCursorPageable DEFAULT_20 = new DingCursorPageable(0L, 20);
    /**
     * 分页偏移，默认值：0
     */
    private final Long cursor;

    /**
     * 分页大小，默认值：20，最大值200(具体值参考对接分页的接口文档)
     */
    private final Integer size;


}
