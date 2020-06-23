package com.ssp.ding.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 钉钉用户请求数据
 *
 * @author: sunshaoping
 * @date: Create by in 1:35 下午 2020/6/8
 */
@Getter
@Builder
public class DingUserRequest {
    /**
     * 手机号码，企业内必须唯一，不可重复。如果是国际号码，请使用+xx-xxxxxx的格式
     */
    private final String mobile;
    /**
     * 国家地区码
     */
    private final String stateCode;
    /**
     * 数组类型，数组里面值为整型，成员所属部门id列表
     */
    private final List<Long> department;
    /**
     * 邮箱。长度为0~64个字符。企业内必须唯一，不可重复
     */
    private final String email;
    /**
     * 扩展属性，可以设置多种属性（手机上最多显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置）。
     * <p>
     * 该字段的值支持链接类型填写，同时链接支持变量通配符自动替换，目前支持通配符有：userid，corpid。示例： [工位地址](http://www.dingtalk.com?userid=#userid#&corpid=#corpid#)
     */
    private final Map<String, String> extAttr;
    /**
     * 入职时间
     */
    private final LocalDate hiredDate;
    /**
     * 是否号码隐藏，true表示隐藏，false表示不隐藏。
     * <p>
     * 隐藏手机号后，手机号在个人资料页隐藏，但仍可对其发DING、发起钉钉免费商务电话。
     */
    private final Boolean isHide;
    /**
     * 是否高管模式，
     * <p>
     * true表示是，
     * <p>
     * false表示不是。
     * <p>
     * <p>
     * <p>
     * 开启后，手机号码对所有员工隐藏。普通员工无法对其发DING、发起钉钉免费商务电话。高管之间不受影响。
     */
    private final Boolean isSenior;
    /**
     * 员工工号。对应显示到OA后台和客户端个人资料的工号栏目。
     */
    private final String jobNumber;
    /**
     * 成员名称。
     * <p>
     * 长度为1~64个字符
     */
    private final String name;
    /**
     * 在对应的部门中的排序，
     * <p>
     * Map结构的json字符串，key是部门的id, value是人员在这个部门的排序值
     */
    private final Map<String, Integer> orderInDepts;
    /**
     * 员工的企业邮箱，员工的企业邮箱已开通，才能增加此字段， 否则会报错
     */
    private final String orgEmail;
    /**
     * 职位信息。
     * <p>
     * 长度为0~64个字符
     */
    private final String position;
    /**
     * 备注，长度为0~1000个字符
     */
    private final String remark;
    /**
     * 分机号，长度为0~50个字符，企业内必须唯一，不可重复
     */
    private final String tel;
    /**
     * 员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改，企业内必须唯一。
     * <p>
     * 长度为1~64个字符，如果不传，服务器将自动生成一个userid。
     */
    private final String userId;
    /**
     * 办公地点，长度为0~50个字符
     */
    private final String workPlace;

}
