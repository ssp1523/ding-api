package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.ssp.ding.DingUserService;
import com.ssp.ding.conf.DingUserConf;
import com.ssp.ding.request.DingUserRequest;
import com.ssp.ding.enumeration.ContactType;
import com.ssp.ding.enumeration.OnlyActive;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.ssp.ding.response.*;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.exception.DingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


/**
 * 钉钉用户通讯录默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:39 下午 2020/6/7
 */
public class DefaultDingUserService extends BaseDingService implements DingUserService, DingUserConf {

    @Override
    public String create(DingUserRequest request) throws DingException {
        OapiUserCreateRequest createRequest = convert(request, OapiUserCreateRequest.class);
        OapiUserCreateResponse response = execute(CREATE, createRequest);
        return response.getUserid();
    }

    @Override
    public void update(String userId, DingUserRequest request, Locale lang) throws DingException {
        OapiUserUpdateRequest updateRequest = convert(request, OapiUserUpdateRequest.class);

        updateRequest.setUserid(userId);
        updateRequest.setLang(lang.toString());
        execute(UPDATE, updateRequest);
    }

    @Override
    public void delete(String userId) {
        OapiUserDeleteRequest request = new OapiUserDeleteRequest();
        request.setUserid(userId);
        execute(DELETE, request);

    }

    @Override
    public DingUserResponse getUser(String userId) throws DingException {
        Assert.notBlank(userId, "userId 必输");
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid(userId);
        OapiUserGetResponse oapiUserGetResponse = execute(GET, request);
        return convert(oapiUserGetResponse, DingUserResponse.class);
    }

    @Override
    public List<String> getDeptMember(Long deptId) throws DingException {
        Assert.notNull(deptId, "deptId 必输");
        OapiUserGetDeptMemberRequest req = new OapiUserGetDeptMemberRequest();
        req.setDeptId(String.valueOf(deptId));
        OapiUserGetDeptMemberResponse rsp = execute(GET_DEPT_MEMBER, req);
        return rsp.getUserIds();
    }

    @Override
    public Page<DingUserSimpleResponse> simpleList(Pageable pageable, Long deptId) throws DingException {
        Assert.notNull(deptId, "deptId 必输");

        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(deptId);
        request.setOffset(pageable.getOffset());
        request.setSize((long) pageable.getPageSize());
        request.setOrder(getOrder(pageable));

        OapiUserSimplelistResponse response = execute(SIMPLE_LIST, request);
        List<OapiUserSimplelistResponse.Userlist> userList = response.getUserlist();

        if (CollUtil.isEmpty(userList)) {
            return Page.empty();
        }
        List<DingUserSimpleResponse> list = userList.stream()
                .map(this::createDingUserSimpleResponse)
                .collect(Collectors.toList());

        return new DingPage<>(list, response.getHasMore());
    }

    private DingUserSimpleResponse createDingUserSimpleResponse(OapiUserSimplelistResponse.Userlist userList) {
        return convert(userList, DingUserSimpleResponse.class);
    }

    @Override
    public Page<DingUserResponse> listByPage(Pageable pageable, Long deptId) throws DingException {
        Assert.notNull(deptId, "deptId 必输");
        Assert.notNull(pageable, "pageable 必输");

        OapiUserListbypageRequest request = new OapiUserListbypageRequest();
        request.setDepartmentId(deptId);
        request.setOffset(pageable.getOffset());
        request.setSize((long) pageable.getPageSize());
        request.setOrder(getOrder(pageable));
        request.setHttpMethod("GET");
        OapiUserListbypageResponse response = execute(LIST_BY_PAGE, request);
        List<OapiUserListbypageResponse.Userlist> userList = response.getUserlist();
        if (CollUtil.isEmpty(userList)) {
            return Page.empty();
        }
        List<DingUserResponse> list = userList.stream()
                .map(this::createDingUserResponse)
                .collect(Collectors.toList());

        return new DingPage<>(list, response.getHasMore());
    }

    private DingUserResponse createDingUserResponse(OapiUserListbypageResponse.Userlist userList) {
        return convert(userList, DingUserResponse.class);
    }

    /**
     * 支持分页查询，部门成员的排序规则，默认不传是按自定义排序；
     * <p>
     * entry_asc：代表按照进入部门的时间升序，
     * <p>
     * entry_desc：代表按照进入部门的时间降序，
     * <p>
     * modify_asc：代表按照部门信息修改时间升序，
     * <p>
     * modify_desc：代表按照部门信息修改时间降序，
     * <p>
     * custom：代表用户定义(未定义时按照拼音)排序
     */
    private String getOrder(Pageable pageable) {
        Sort sort = pageable.getSort();
        if (ObjectUtil.isEmpty(sort)) {
            return null;
        }
        Sort.Order order = sort.iterator().next();
        return String.join("_", order.getProperty(), order.getDirection().name().toLowerCase());
    }

    public static final OapiUserGetAdminRequest GET_ADMIN_REQUEST = new OapiUserGetAdminRequest();

    @Override
    public List<AdminResponse> getAdmin() throws DingException {
        OapiUserGetAdminResponse response = execute(GET_ADMIN, GET_ADMIN_REQUEST);
        List<OapiUserGetAdminResponse.AdminList> adminList = response.getAdminList();
        return adminList.stream()
                .map(admin ->
                        convert(admin, AdminResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getAdminScope(String userId) throws DingException {
        OapiUserGetAdminScopeRequest req = new OapiUserGetAdminScopeRequest();
        req.setUserid(userId);
        OapiUserGetAdminScopeResponse rsp = execute(GET_ADMIN_SCOPE, req);
        return rsp.getDeptIds();
    }


    @Override
    public UserIdResponse getUserIdByUnionId(String unionId) {
        OapiUserGetUseridByUnionidRequest request = new OapiUserGetUseridByUnionidRequest();
        request.setUnionid(unionId);
        OapiUserGetUseridByUnionidResponse response = execute(GET_USER_ID_BY_UNION_ID, request);
        return UserIdResponse.builder()
                .userId(response.getUserid())
                .contactType(ContactType.valueOf(response.getContactType()))
                .build();
    }

    @Override
    public String getByMobile(String mobile) throws DingException {
        OapiUserGetByMobileRequest request = new OapiUserGetByMobileRequest();
        request.setMobile(mobile);
        OapiUserGetByMobileResponse response = execute(GET_BY_MOBILE, request);
        return response.getUserid();
    }

    @Override
    public Long getOrgUserCount(OnlyActive onlyActive) {
        OapiUserGetOrgUserCountRequest request = new OapiUserGetOrgUserCountRequest();
        request.setOnlyActive(Long.valueOf(onlyActive.getType()));
        OapiUserGetOrgUserCountResponse response = execute(GET_ORG_USER_COUNT, request);
        return response.getCount();
    }

    @Override
    public Page<String> getInactive(Pageable pageable, LocalDate queryDate) {
        Assert.notNull(pageable, "pageable 必输");
        Assert.notNull(queryDate, "queryDate 必输");

        OapiInactiveUserGetRequest request = new OapiInactiveUserGetRequest();
        // 分页偏移量
        request.setOffset(pageable.getOffset());
        // 每页size，最多100
        request.setSize((long) pageable.getPageSize());
        // 查询日期
        request.setQueryDate(DateTimeFormatter.BASIC_ISO_DATE.format(queryDate));
        OapiInactiveUserGetResponse response = execute(GET_INACTIVE_USER, request);

        OapiInactiveUserGetResponse.PageVo result = response.getResult();
        return new DingPage<>(result.getList(), result.getHasMore());
    }
}
