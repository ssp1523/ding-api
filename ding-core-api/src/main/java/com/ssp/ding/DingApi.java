package com.ssp.ding;

import javax.annotation.Nonnull;

/**
 * 钉钉接口,实现类尽量使用枚举
 *
 * @author: sunshaoping
 * @date: Create by in 3:58 下午 2020/8/13
 */
public interface DingApi {


    /**
     * 接口路径
     */
    @Nonnull
    String getPath();

    /**
     * 接口简述
     */
    @Nonnull
    String getSketch();


}
