package com.ssp.ding.request;

import lombok.Data;

import java.util.List;

/**
 * 部门请求数据
 *
 * @author: sunshaoping
 * @date: Create by in 1:22 下午 2020/6/8
 */
@Data
public class DingDepartmentCreateRequest {
    /**
     * 是否创建一个关联此部门的企业群，默认为false
     */
    private Boolean createDeptGroup;
    /**
     * 是否隐藏部门，
     * <p>
     * true表示隐藏
     * <p>
     * false表示显示
     */
    private Boolean deptHiding;
    /**
     * 可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的字符串，总数不能超过200
     */
    private List<Long> deptPermits;
    /**
     * 部门名称，长度限制为1~64个字符，不允许包含字符‘-’‘，’以及‘,’
     */
    private String name;
    /**
     * 在父部门中的排序值，order值小的排序靠前
     */
    private String order;
    /**
     * 限制本部门成员查看通讯录，限制开启后，本部门成员只能看到限定范围内的通讯录。true表示限制开启
     */
    private Boolean outerDept;
    /**
     * outerDept为true时，可以配置该字段，为true时，表示只能看到所在部门及下级部门通讯录
     */
    private Boolean outerDeptOnlySelf;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成。总数不能超过200
     */
    private List<Long> outerPermitDepts;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串
     */
    private List<String> outerPermitUsers;

    /**
     * 父部门id，根部门id为1
     */
    private Long parentId;

    /**
     * 部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射
     */
    private String sourceIdentifier;
    /**
     * 可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的字符串。总数不能超过200
     */
    private List<String> userPermits;

}
