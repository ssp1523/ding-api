package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

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
@Builder
public class DingUserResponse {
    /**
     * 员工名字
     */
    private String name;
    /**
     * 员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     */
    private String userId;
    /**
     * 是否已经激活，true表示已激活，false表示未激活
     */
    private Boolean active;
    /**
     * 头像url
     */
    private String avatar;
    /**
     * 成员所属部门id列表
     */
    private List<Long> department;
    /**
     * 员工的电子邮箱
     */
    private String email;
    /**
     * 扩展属性，可以设置多种属性（手机上最多显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置）。
     * <p>
     * 该字段的值支持链接类型填写，同时链接支持变量通配符自动替换，目前支持通配符有：userid，corpid。示例： [工位地址](http://www.dingtalk.com?userid=#userid#&corpid=#corpid#)
     */
    private Map<String, String> extAttr;
    /**
     * 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     */
    private LocalDate hiredDate;
    /**
     * 是否为企业的管理员，true表示是，false表示不是
     */
    private Boolean isAdmin;
    /**
     * 是否为企业的老板，true表示是，false表示不是
     */
    private Boolean isBoss;
    /**
     * 是否号码隐藏，true表示隐藏，false表示不隐藏
     */
    private Boolean isHide;

    /**
     * 在对应的部门中是否为主管：，key是部门的id，value是人员在这个部门中是否为主管，true表示是，false表示不是
     */
    private Map<Long, Boolean> isLeaderInDepts;
    /**
     * 是否是高管
     */
    private Boolean isSenior;
    /**
     * 员工工号
     */
    private String jobNumber;
    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 在对应的部门中的排序，Map结构 ，key是部门的id，value是人员在这个部门的排序值
     */
    private Map<Long, Long> orderInDepts;
    /**
     * 员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     */
    private String orgEmail;
    /**
     * 职位信息
     */
    private String position;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户所在角色列表
     */
    private List<DingRole> roles;
    /**
     * 国家地区码
     */
    private String stateCode;
    /**
     * 分机号（仅限企业内部开发调用）
     */
    private String tel;
    /**
     * 员工在当前开发者企业账号范围内的唯一标识，系统生成，固定值，不会改变
     */
    private String unionId;
    /**
     * 办公地点
     */
    private String workPlace;

}
