package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 用户详情信息
 *
 * @author: sunshaoping
 * @date: Create by in 3:39 下午 2020/6/7
 */
@Data
public class DingUserResponse {

    private String name;

    private String userId;

    private Boolean active;
    private String associatedUnionId;
    private String avatar;
    private List<Long> department;
    private String dingId;
    private String email;
    /**
     *
     * 扩展属性，可以设置多种属性（手机上最多显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置）。
     *
     * 该字段的值支持链接类型填写，同时链接支持变量通配符自动替换，目前支持通配符有：userid，corpid。示例： [工位地址](http://www.dingtalk.com?userid=#userid#&corpid=#corpid#)
     */
    private Map<String, String> extAttr;
    private LocalDate hiredDate;
    private String inviteMobile;
    private Boolean isAdmin;
    private Boolean isBoss;
    private Boolean isCustomizedPortal;
    private Boolean isHide;

    /**
     * 在对应的部门中是否为主管：，key是部门的id，value是人员在这个部门中是否为主管，true表示是，false表示不是
     */
    private Map<Long, Boolean> isLeaderInDepts;
    private Boolean isLimited;
    private Boolean isSenior;
    private String jobNumber;
    private String managerUserId;
    private Boolean memberView;
    private String mobile;
    private String mobileHash;
    private String nickname;
    private String openId;

    /**
     * 在对应的部门中的排序，Map结构 ，key是部门的id，value是人员在这个部门的排序值
     */
    private Map<Long, Long> orderInDepts;
    private String orgEmail;
    private String position;
    private String remark;
    private List<DingRole> roles;
    private String stateCode;
    private String tel;
    private String unionId;
    private String workPlace;

}
