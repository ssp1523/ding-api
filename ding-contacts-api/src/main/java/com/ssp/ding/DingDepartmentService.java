package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingDepartmentCreateRequest;
import com.ssp.ding.request.DingDepartmentUpdateRequest;
import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.ssp.ding.response.DingDepartmentResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Locale;

/**
 * 钉钉部门管理
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq
 *
 * @author: sunshaoping
 * @date: Create by in 1:08 下午 2020/6/8
 */
public interface DingDepartmentService {


    /**
     * 创建部门
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/create?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/97578482
     */
    Long create(DingDepartmentCreateRequest request) throws DingException;

    /**
     * 更新部门
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/ed9c05fc
     *
     * @param id   部门id
     * @param lang 通讯录语言(默认zh_CN另外支持en_US)
     * @return 已经更新的部门id
     */
    Long update(Long id, DingDepartmentUpdateRequest request, Locale lang) throws DingException;

    /**
     * @see #update(Long, DingDepartmentUpdateRequest, Locale)
     */
    default Long update(Long id, DingDepartmentUpdateRequest request) throws DingException {
        return update(id, request, Locale.SIMPLIFIED_CHINESE);
    }


    /**
     * 删除部门
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/delete?access_token=ACCESS_TOKEN&id=ID
     * <p>
     * 接口文档: https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/5e0da2d3
     *
     * @param id 部门id
     *           <p>
     *           (注：不能删除根部门；当部门里有员工，或者部门的子部门里有员工，也不能删除)
     */
    void delete(Long id) throws DingException;


    /**
     * 获取子部门ID列表
     * <p>
     * 注意：该接口能获取到企业部门下的所有直属子部门列表，不受授权范围限制，ISV可以根据该接口完成企业部门的遍历。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/list_ids?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/97578482
     *
     * @param parentId 父部门id。根部门的话传1
     */
    List<Long> listIds(Long parentId) throws DingException;

    /**
     * 获取部门列表
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/list?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/e6e1604e
     *
     * @param parentId   父部门id（如果不传，默认部门为根部门，根部门ID为1）
     * @param fetchChild 是否递归部门的全部子部门，ISV微应用固定传递false
     * @param lang       通讯录语言（默认zh_CN，未来会支持en_US）
     */
    List<DingDepartmentResponse> list(Long parentId, Boolean fetchChild, Locale lang) throws DingException;

    /**
     * 获取部门详情
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/get?access_token=ACCESS_TOKEN&id=123
     * <p>
     * 接口地址:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/5bf960de
     *
     * @param id 部门id
     */
    DingDepartmentDetailResponse get(Long id) throws DingException;

    /**
     * 查询部门的所有上级父部门路径
     * 注意：此接口不受授权范围的限制。
     * <p>
     * 假设部门的组织结构如下：
     * 1
     * |->123
     * |->456
     * |->789
     * 当传入部门id为789时，返回的结果按顺序依次为当前部门id及其所有父部门的ID，直到根部门，如[789,456,123,1]。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/list_parent_depts_by_dept?access_token=ACCESS_TOKEN&id=ID
     * <p>
     * 接口文档: https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/3dbe8e4a
     *
     * @param id 希望查询的部门的id，包含查询的部门本身
     */
    List<Long> listParentDeptsByDept(Long id) throws DingException;

    /**
     * 查询指定用户的所有上级父部门路径
     * 注意：此接口不受授权范围的限制。
     * <p>
     * 假设用户所属部门的组织结构如下
     * 1
     * |->123
     * |->456  ->员工A
     * |->789  ->员工A
     * 当传入员工A的userId时，返回的结果按顺序依次为其所有父部门的ID，直到根部门，如[[456,123,1],[789,1]]。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/department/list_parent_depts?access_token=ACCESS_TOKEN&userId=USERID
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/eda9c2ec
     *
     * @param userId 希望查询的用户的id
     */
    List<List<Long>> listParentDepts(String userId) throws DingException;


    /**
     * 接口api
     */
    @Getter
    @RequiredArgsConstructor
    enum Api implements DingApi {
        /**
         * @see #create(DingDepartmentCreateRequest)
         */
        CREATE("/department/create", "创建部门"),
        /**
         * @see #update(Long, DingDepartmentUpdateRequest)
         * @see #update(Long, DingDepartmentUpdateRequest, Locale)
         */
        UPDATE("/department/update", "更新部门"),
        /**
         * @see #delete(Long)
         */
        DELETE("/department/delete", "删除部门"),
        /**
         * @see #get(Long)
         */
        GET("/department/get", "获取部门详情"),

        /**
         * @see #listIds(Long)
         */
        LIST_IDS("/department/list_ids", "获取子部门ID列表"),

        /**
         * @see #list(Long, Boolean, Locale)
         */
        LIST("/department/list", "获取部门列表"),

        /**
         * @see #listParentDeptsByDept(Long)
         */
        LIST_PARENT_DEPTS_BY_DEPT("/department/list_parent_depts_by_dept", "获取部门部门详情"),

        /**
         * @see #listParentDepts(String)
         */
        LIST_PARENT_DEPTS("/department/list_parent_depts", "获取管理员列表"),


        ;

        private final String path;

        private final String sketch;

    }

}
