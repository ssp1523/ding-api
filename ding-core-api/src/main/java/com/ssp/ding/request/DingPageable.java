package com.ssp.ding.request;

import lombok.Getter;

/**
 * 钉钉分页请求
 *
 * @author: sunshaoping
 * @date: Create by in 4:20 下午 2020/6/17
 */
@Getter
public class DingPageable {

    public static final DingPageable DEFAULT = new DingPageable(0, 20);
    /**
     * 分页偏移，默认值：0
     */
    private final int offset;

    /**
     * 分页大小，默认值：20，最大值200(具体值参考对接分页的接口文档)
     */
    private final int size;


    public DingPageable(int offset, int size) {
        this.offset = offset;
        this.size = size;
    }
}
