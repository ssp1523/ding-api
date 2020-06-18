package com.ssp.ding.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 钉钉游标分页封装
 *
 * @author: sunshaoping
 * @date: Create by in 10:33 上午 2020/6/8
 */
@Getter
@RequiredArgsConstructor
public class DingCursorPage<T> {

    /**
     * 下次分页获取的起始游标
     */
    private final Long nextCursor;

    /**
     * 分页数据
     */
    private final List<T> content;


}
