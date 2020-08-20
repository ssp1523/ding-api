package com.ssp.ding.utils;

import java.util.Objects;

/**
 * 数值型转换工具,处理null情况
 *
 * @author: sunshaoping
 * @date: Create by in 6:37 下午 2020/7/1
 */
public class NumberConvertUtils {

    public static Long toLong(Integer num) {
        if (Objects.isNull(num)) {
            return null;
        }
        return Long.valueOf(num);
    }

    public static Integer toLong(Long num) {
        if (Objects.isNull(num)) {
            return null;
        }
        return Math.toIntExact(num);
    }

}
