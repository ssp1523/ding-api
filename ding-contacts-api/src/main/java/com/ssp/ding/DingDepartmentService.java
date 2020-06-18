package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingDepartmentCreateRequest;
import com.ssp.ding.request.DingDepartmentUpdateRequest;
import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.ssp.ding.response.DingDepartmentResponse;

import java.util.List;
import java.util.Locale;

/**
 * 钉钉部门管理
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq
 *
 * @author: sunshaoping
 * @date: Create by in 1:08 下午 2020/6/8
 */
public interface DingDepartmentService  {


    /**
     * 创建部门
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/97578482
     */
    Long create(DingDepartmentCreateRequest request) throws DingException;

    /**
     * 更新部门
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/ed9c05fc
     */
    Long update(Long id, DingDepartmentUpdateRequest request, Locale lang) throws DingException;

    default Long update(Long id, DingDepartmentUpdateRequest request) throws DingException {
        return update(id, request, Locale.SIMPLIFIED_CHINESE);
    }


    /**
     * 删除部门
     * 接口文档: https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/5e0da2d3
     */
    void delete(Long id) throws DingException;


    /**
     * 获取子部门ID列表
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/97578482
     *
     * @param parentId 父部门id。根部门的话传1
     */
    List<Long> listIds(Long parentId) throws DingException;

    /**
     * 获取部门列表
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/e6e1604e
     *
     * @param parentId   父部门id（如果不传，默认部门为根部门，根部门ID为1）
     * @param fetchChild 是否递归部门的全部子部门，ISV微应用固定传递false
     * @return
     */
    List<DingDepartmentResponse> list(Long parentId, Boolean fetchChild) throws DingException;

    /**
     * 获取部门详情
     * 接口地址:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/5bf960de
     *
     * @param id 部门id
     * @return
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
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi3/fuqv8x/eda9c2ec
     *
     * @param userId 希望查询的用户的id
     */
    List<List<Long>> listParentDepts(String userId) throws DingException;


}
