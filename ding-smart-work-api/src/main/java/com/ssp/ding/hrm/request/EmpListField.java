package com.ssp.ding.hrm.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 花名册字段信息列表
 *
 * @author: sunshaoping
 * @date: Create by in 1:41 下午 2020/6/18
 */
@Getter
@Builder
public class EmpListField {

    private final List<EmpField> section;

}
