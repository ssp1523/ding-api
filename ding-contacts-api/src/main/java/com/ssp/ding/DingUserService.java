package com.ssp.ding;

import com.ssp.ding.enumeration.OnlyActive;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingUserRequest;
import com.ssp.ding.response.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

/**
 * 钉钉通讯录用户
 * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851
 *
 * @author: sunshaoping
 * @date: Create by in 3:37 下午 2020/6/7
 */
public interface DingUserService {

    /**
     * 创建用户
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/b6a05ccd
     */
    String create(DingUserRequest request) throws DingException;

    /**
     * 更新用户
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/1ce6da36
     */
    void update(String userId, DingUserRequest request, Locale lang) throws DingException;

    default void update(String userId, DingUserRequest request) throws DingException {
        update(userId, request, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 删除用户
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/1ce6da36
     */
    void delete(String userId);

    /**
     * 获取用户详情
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/AaRQe
     */
    DingUserResponse getUser(String userId) throws DingException;

    /**
     * 获取部门用户userid列表
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/vEcIg
     */
    List<String> getDeptMember(Long deptId) throws DingException;

    /**
     * 获取部门用户
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/296c1ed7
     *
     * @param pageable 分页
     */
    DingPage<DingUserSimpleResponse> simpleList(DingPageable pageable, Long deptId) throws DingException;

    /**
     * 获取部门用户详情
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/7d2092e8
     *
     * @param pageable 分页
     */
    DingPage<DingUserResponse> listByPage(DingPageable pageable, Long deptId) throws DingException;

    /**
     * 获取管理员列表
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/d5d3385f
     */
    List<AdminResponse> getAdmin() throws DingException;


    /**
     * 获取管理员通讯录权限范围,可管理的部门id列表
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/22fb487e
     */
    List<Long> getAdminScope(String userId) throws DingException;

    /**
     * 根据unionid获取userid
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/602f4b15
     */
    UserIdResponse getUserIdByUnionId(String unionId) throws DingException;

    /**
     * 根据手机号获取userid
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/soV11
     */
    String getByMobile(String mobile) throws DingException;

    /**
     * 获取企业员工人数
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/HrMOb
     */
    Long getOrgUserCount(OnlyActive onlyActive) throws DingException;

    /**
     * 未登录钉钉的员工ID列表
     * 企业使用此接口可查询指定日期内未登录钉钉的企业员工列表 (每天9点后调用接口才能确保获取前一天数据)
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/SHDRH
     *
     * @param pageable 分页
     */
    DingPage<String> getInactive(DingPageable pageable, LocalDate queryDate);
}
