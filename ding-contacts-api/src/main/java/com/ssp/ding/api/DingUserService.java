package com.ssp.ding.api;

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
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/b6a05ccd
     *
     * @return 员工唯一标识
     */
    String create(DingUserRequest request) throws DingException;

    /**
     * 更新用户
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/1ce6da36
     *
     * @param userId 员工id，不可修改，长度为1~64个字符
     * @param lang   通讯录语言  (默认zh_CN另外支持en_US)
     */
    void update(String userId, DingUserRequest request, Locale lang) throws DingException;

    /**
     * @see #update(String, DingUserRequest, Locale)
     */
    default void update(String userId, DingUserRequest request) throws DingException {
        update(userId, request, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 删除用户
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/delete?access_token=ACCESS_TOKEN&userid=zhangsan
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/1ce6da36
     *
     * @param userId 员工id
     */
    void delete(String userId);

    /**
     * 获取用户详情
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/get?access_token=ACCESS_TOKEN&userid=zhangsan
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/AaRQe
     *
     * @param userId 员工id
     */
    DingUserResponse getUser(String userId) throws DingException;

    /**
     * 获取部门用户userid列表
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/getDeptMember?access_token=ACCESS_TOKEN&deptId=1
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/vEcIg
     *
     * @param deptId 部门id
     */
    List<String> getDeptMember(Long deptId) throws DingException;

    /**
     * 获取部门用户
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/simplelist?access_token=ACCESS_TOKEN&department_id=1
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/296c1ed7
     *
     * @param pageable 分页
     * @param deptId   获取的部门id
     */
    DingPage<DingUserSimpleResponse> simpleList(DingPageable pageable, Long deptId) throws DingException;

    /**
     * @see #simpleList(DingPageable, Long)
     */
    default DingPage<DingUserSimpleResponse> simpleList(Long deptId) throws DingException {
        return simpleList(DingPageable.DEFAULT_20, deptId);
    }

    /**
     * 获取部门用户详情
     * <p>
     * 如果您想调用通讯录接口并同时获取员工手机号，请先参考通讯录权限说明，设置下通讯录接口权限和手机号等敏感字段权限
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/listbypage?access_token=ACCESS_TOKEN&department_id=1
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/7d2092e8
     *
     * @param pageable 分页
     * @param deptId   获取的部门id，1表示根部门
     */
    DingPage<DingUserResponse> listByPage(DingPageable pageable, Long deptId) throws DingException;

    /**
     * @see #listByPage(DingPageable, Long)
     */
    default DingPage<DingUserResponse> listByPage(Long deptId) throws DingException {
        return listByPage(DingPageable.DEFAULT_20, deptId);
    }

    /**
     * 获取管理员列表
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/get_admin?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/d5d3385f
     */
    List<AdminResponse> getAdmin() throws DingException;


    /**
     * 获取管理员通讯录权限范围,可管理的部门id列表
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/user/get_admin_scope?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/22fb487e
     *
     * @param userId 员工id
     * @return 可管理的部门id列表
     */
    List<Long> getAdminScope(String userId) throws DingException;

    /**
     * 根据unionid获取userid
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/getUseridByUnionid?access_token=ACCESS_TOKEN&unionid=xxx
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/602f4b15
     *
     * @param unionId 员工在当前开发者企业账号范围内的唯一标识，系统生成，固定值，不会改变
     */
    UserIdResponse getUserIdByUnionId(String unionId) throws DingException;

    /**
     * 根据手机号获取userid
     * <p>
     * 企业使用此接口可通过手机号获取其所对应员工的userid。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/get_by_mobile?access_token=ACCESS_TOKEN&mobile=1xxxxxxxxxx
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/soV11
     *
     * @param mobile 手机号码
     * @return 员工在当前企业内的唯一标识。
     */
    String getByMobile(String mobile) throws DingException;

    /**
     * 获取企业员工人数
     * <p>
     * 请求地址：https://oapi.dingtalk.com/user/get_org_user_count?access_token=ACCESS_TOKEN&onlyActive=0
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/HrMOb
     *
     * @param onlyActive 0：包含未激活钉钉的人员数量
     *                   <p>
     *                   1：不包含未激活钉钉的人员数量
     * @return 企业员工数量
     */
    Long getOrgUserCount(OnlyActive onlyActive) throws DingException;

    /**
     * 未登录钉钉的员工ID列表
     * <p>
     * 企业使用此接口可查询指定日期内未登录钉钉的企业员工列表 (每天9点后调用接口才能确保获取前一天数据)
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/inactive/user/get?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档地址:https://ding-doc.dingtalk.com/doc#/serverapi2/ege851/SHDRH
     *
     * @param pageable  分页
     * @param queryDate 查询日期
     * @return 未登录用户userId列表
     */
    DingPage<String> getInactive(DingPageable pageable, LocalDate queryDate);

    /**
     * @see #getInactive(DingPageable, LocalDate)
     */
    default DingPage<String> getInactive(LocalDate queryDate) {
        return getInactive(DingPageable.DEFAULT_20, queryDate);
    }
}
