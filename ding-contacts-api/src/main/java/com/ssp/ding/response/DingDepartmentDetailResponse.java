package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 部门详情
 *
 * @author: sunshaoping
 * @date: Create by in 1:22 下午 2020/6/8
 */
@Data
@Builder
public class DingDepartmentDetailResponse {

    /**
     * 部门id
     */
    private Long id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 当前部门在父部门下的所有子部门中的排序值
     */
    private Integer order;
    /**
     * 父部门id，根部门为1
     */
    private Long parentId;
    /**
     * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    private Boolean createDeptGroup;
    /**
     * 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     */
    private Boolean autoAddUser;
    /**
     * 是否隐藏部门，true表示隐藏，false表示显示
     */
    private Boolean deptHiding;
    /**
     * 可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的字符串
     */
    private List<Long> deptPermits;
    /**
     * 可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串
     */
    private List<String> userPermits;
    /**
     * 是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     */
    private Boolean outerDept;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串
     */
    private List<Long> outerPermitDepts;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串
     */
    private List<String> outerPermitUsers;
    /**
     * 企业群群主
     */
    private String orgDeptOwner;
    /**
     * 部门的主管列表，取值为由主管的userid组成的字符串
     */
    private List<String> deptManagerUserIdList;
    /**
     * 部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射
     */
    private String sourceIdentifier;
    /**
     * 部门群是否包含子部门
     */
    private Boolean groupContainSubDept;
}
