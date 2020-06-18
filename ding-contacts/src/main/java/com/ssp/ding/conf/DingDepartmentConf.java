package com.ssp.ding.conf;

/**
 * 钉钉用户常量
 *
 * @author: sunshaoping
 * @date: Create by in 9:54 上午 2020/6/8
 */
public interface DingDepartmentConf {

    /**
     * 创建用户
     */
    String CREATE = "/department/create";
    /**
     * 更新用户
     */
    String UPDATE = "/department/update";
    /**
     * 删除用户
     */
    String DELETE = "/department/delete";
    /**
     * 获取用户详情
     */
    String GET = "/department/get";

    /**
     * 获取子部门ID列表
     */
    String LIST_IDS = "/department/list_ids";

    /**
     * 获取部门列表
     */
    String LIST = "/department/list";

    /**
     * 获取部门用户详情
     */
    String LIST_PARENT_DEPTS_BY_DEPT = "/department/list_parent_depts_by_dept";

    /**
     * 获取管理员列表
     */
    String LIST_PARENT_DEPTS = "/department/list_parent_depts";

    /**
     * 获取管理员通讯录权限范围
     */
    String GET_ADMIN_SCOPE = "/department/get_admin_scope";

    /**
     * 查询管理员是否具备管理某个应用的权限
     */
    String CAN_ACCESS_MICRO_APP = "/department/can_access_microapp";
    /**
     * 根据unionid获取departmentid
     */
    String GET_USER_ID_BY_UNION_ID = "/department/getUseridByUnionid";
    /**
     * 获取企业员工人数
     */
    String GET_ORG_USER_COUNT = "/department/get_org_department_count";


}
