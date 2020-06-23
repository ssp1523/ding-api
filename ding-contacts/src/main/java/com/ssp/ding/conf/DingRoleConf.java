package com.ssp.ding.conf;

/**
 * 钉钉角色常量
 *
 * @author: sunshaoping
 * @date: Create by in 4:48 下午 2020/6/9
 */
public interface DingRoleConf {

    /**
     * 创建用户
     */
    String ADD_ROLE = "role/add_role";

    String UPDATE_ROLE = "role/update_role";

    String ADD_ROLE_GROUP = "role/add_role_group";

    String DELETE_ROLE = "topapi/role/deleterole";

    String GET_ROLE = "topapi/role/getrole";

    String ADD_ROLES_FOREMPS = "topapi/role/addrolesforemps";

    String REMOVE_ROLES_FOREMPS = "topapi/role/removerolesforemps";

    String SCOPE_UPDATE = "topapi/role/scope/update";

    String ROLE_LIST = "/topapi/role/list";

    String ROLE_SIMPLE_LIST = "/topapi/role/simplelist";

    String ROLE_GET_ROLE_GROUP = "/topapi/role/getrolegroup";

}
