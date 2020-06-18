package com.ssp.ding.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;

import java.time.LocalDate;
import java.util.Date;

/**
 * 时间工具
 *
 * @author: sunshaoping
 * @date: Create by in 5:26 下午 2020/6/8
 */
public class DateUtils {


    public static LocalDate toLocalDate(Date date) {
        if (ObjectUtil.isEmpty(date)) {
            return null;
        }
        DateTime dateTime = DateUtil.date(date);
        return LocalDate.of(dateTime.year(), dateTime.month(), dateTime.dayOfMonth());
    }
}
