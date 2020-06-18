package com.ssp.ding.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 钉钉分页封装
 *
 * @author: sunshaoping
 * @date: Create by in 10:33 上午 2020/6/8
 */
@Getter
@RequiredArgsConstructor
public class DingPage<T> {

    /**
     * 是否还有更多数据
     */
    private final boolean hasMore;

    private final List<T> content;


}
