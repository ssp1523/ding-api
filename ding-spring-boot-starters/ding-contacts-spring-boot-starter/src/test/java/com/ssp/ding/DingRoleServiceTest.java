package com.ssp.ding;

import com.ssp.ding.request.DingPageable;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingRoleGroupResponse;
import com.ssp.ding.response.DingRoleResponse;
import com.ssp.ding.response.RoleUserSimpleResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @author: sunshaoping
 * @date: Create by in 5:16 下午 2020/8/12
 */
public class DingRoleServiceTest extends BaseTest {

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
        dingRoleService.updateRole(1541467273L, "架构师");
    }

    @Test
    public void deleteRole() {
        dingRoleService.deleteRole(1541467273L);
    }

    @Test
    public void getRole() {
        DingRoleResponse role = dingRoleService.getRole(567412242L);
        System.out.println(role);
    }

    @Test
    public void list() {
        DingPage<DingRoleGroupResponse> list = dingRoleService.list();
        System.out.println(list.getContent());
    }

    @Test
    public void testList() {
        DingPage<DingRoleGroupResponse> list = dingRoleService.list(DingPageable.builder()
                .offset(1)
                .size(10)
                .build());
        System.out.println(list);
    }

    @Test
    public void simpleList() {

        DingPage<RoleUserSimpleResponse> user = dingRoleService.simpleList(1541386530L);
        System.out.println(user);

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
        dingRoleService.addRolesForEmps(
                Arrays.asList(567412256L, 567412257L),
                Arrays.asList("0600081849842061", "0136695831937065")
        );
    }

    @Test
    public void removeRolesForemps() {
        dingRoleService.removeRolesForEmps(
                Arrays.asList(567412256L, 567412257L),
                Arrays.asList("0600081849842061")
        );
    }

    @Test
    public void scopeUpdate() {
        dingRoleService.scopeUpdate(567412256L, "0600081849842061", Arrays.asList(150273007L));
    }
}
