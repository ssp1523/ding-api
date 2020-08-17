package com.ssp.ding.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * 钉钉游标分页封装
 *
 * @author: sunshaoping
 * @date: Create by in 10:33 上午 2020/6/8
 */
@Getter
@ToString
@RequiredArgsConstructor
public class DingCursorPage<T> {

    public static final DingCursorPage<?> EMPTY = new DingCursorPage<>(0L, Collections.emptyList());


    @SuppressWarnings("unchecked")
    public static <T> DingCursorPage<T> empty() {
        return (DingCursorPage<T>) EMPTY;
    }

    /**
     * 下次分页获取的起始游标
     */
    private final Long nextCursor;

    /**
     * 分页数据
     */
    private final List<T> content;


}
