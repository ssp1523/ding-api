package com.ssp.ding.request;

import lombok.Data;

import java.util.List;

/**
 * 外部联系人更新数据
 *
 * @author: sunshaoping
 * @date: Create by in 8:22 下午 2020/6/10
 */
@Data
public class DingExtUpdateContactRequest {

    /**
     * 职位
     */
    private String title;
    /**
     * 备注
     */
    private String remark;
    /**
     * 地址
     */
    private String address;
    /**
     * 姓名
     */
    private String name;
    /**
     * 负责人UserID
     */
    private String followerUserId;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 共享部门ID列表
     */
    private List<Long> shareDeptIds;
    /**
     * 标签
     */
    private List<Long> labelIds;
    /**
     * 共享员工UserID列表
     */
    private List<String> shareUserIds;
}
