package com.ssp.ding.hrm.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 组明细
 *
 * @author: sunshaoping
 * @date: Create by in 1:40 下午 2020/6/18
 */
@Getter
@Builder
public class DingGroupMetaInfoRequest {

    /**
     * 修改字段所在组ID。
     * <p>
     * 不支持修改：sys00-dept、sys00-deptIds、ys01-employeeStatus、sys02-certNo
     */
    private final String groupId;

    /**
     * 花名册字段信息列表
     */
    private final List<EmpListField> sections;
}
