package com.ssp.ding;

import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingRoleGroupResponse;
import com.ssp.ding.response.DingRoleResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author: sunshaoping
 * @date: Create by in 5:16 下午 2020/8/12
 */
public class DingRoleServiceTest extends BaseTest{

    @Autowired
    DingRoleService dingRoleService;

    @Test
    public void addRole() {
        Long groupId = dingRoleService.addRoleGroup("程序员");
        Long roleId = dingRoleService.addRole(groupId, "高级java工程师");
        System.out.println(roleId);
    }

    @Test
    public void updateRole() {
        dingRoleService.updateRole(1541467273L,"架构师");
    }

    @Test
    public void deleteRole() {
        dingRoleService.deleteRole(1541467273L);
    }

    @Test
    public void getRole() {
        DingRoleResponse role = dingRoleService.getRole(1541467273L);
        System.out.println(role);
    }

    @Test
    public void list() {
        DingPage<DingRoleGroupResponse> list = dingRoleService.list();
        System.out.println(list.getContent());
    }

    @Test
    public void testList() {
    }

    @Test
    public void simpleList() {

    }

    @Test
    public void testSimpleList() {
    }

    @Test
    public void getRoleGroup() {
        DingRoleGroupResponse roleGroup = dingRoleService.getRoleGroup(1541350922L);
        System.out.println(roleGroup);
    }

    @Test
    public void addRolesForemps() {
    }

    @Test
    public void removeRolesForemps() {
        //dingRoleService.addRoleGroup()
    }

    @Test
    public void scopeUpdate() {
    }
}
