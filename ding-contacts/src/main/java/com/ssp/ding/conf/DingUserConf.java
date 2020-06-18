package com.ssp.ding.conf;

/**
 * 钉钉用户常量
 *
 * @author: sunshaoping
 * @date: Create by in 9:54 上午 2020/6/8
 */
public interface DingUserConf {

    /**
     * 创建用户
     */
    String CREATE = "/user/create";
    /**
     * 更新用户
     */
    String UPDATE = "/user/update";
    /**
     * 删除用户
     */
    String DELETE = "/user/delete";
    /**
     * 获取用户详情
     */
    String GET = "/user/get";
    /**
     * 获取部门用户userId 列表
     */
    String GET_DEPT_MEMBER = "/user/getDeptMember";

    /**
     * 获取部门用户
     */
    String SIMPLE_LIST = "/user/simplelist";

    /**
     * 获取部门用户详情
     */
    String LIST_BY_PAGE = "/user/listbypage";

    /**
     * 获取管理员列表
     */
    String GET_ADMIN = "/user/get_admin";

    /**
     * 获取管理员通讯录权限范围
     */
    String GET_ADMIN_SCOPE = "/topapi/user/get_admin_scope";

    /**
     * 查询管理员是否具备管理某个应用的权限
     */
    String CAN_ACCESS_MICRO_APP = "/user/can_access_microapp";
    /**
     * 根据unionid获取userid
     */
    String GET_USER_ID_BY_UNION_ID = "/user/getUseridByUnionid";
    /**
     * 根据手机号获取userid
     */
    String GET_BY_MOBILE = "/user/get_by_mobile";
    /**
     * 获取企业员工人数
     */
    String GET_ORG_USER_COUNT = "/user/get_org_user_count";

    String GET_INACTIVE_USER  = "/topapi/inactive/user/get";
}
