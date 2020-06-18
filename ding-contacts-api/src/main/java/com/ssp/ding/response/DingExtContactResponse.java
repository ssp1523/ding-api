package com.ssp.ding.response;

import lombok.Data;

import java.util.List;

/**
 * 外部联系人
 *
 * @author: sunshaoping
 * @date: Create by in 7:45 下午 2020/6/10
 */
@Data
public class DingExtContactResponse  {

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

    /**
     * 国家码
     */
    private String stateCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

}
