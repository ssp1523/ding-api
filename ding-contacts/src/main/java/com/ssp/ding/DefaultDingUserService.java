package com.ssp.ding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.ssp.ding.enumeration.ContactType;
import com.ssp.ding.enumeration.OnlyActive;
import com.ssp.ding.error.ContactsError;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingUserRequest;
import com.ssp.ding.response.*;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.ssp.ding.DingUserService.Api.*;


/**
 * 钉钉用户通讯录默认实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:39 下午 2020/6/7
 */
public class DefaultDingUserService extends BaseDingService implements DingUserService {

    public DefaultDingUserService(DingClient dingClient) {
        super(dingClient);
    }

    @Override
    public String create(DingUserRequest request) throws DingException {
        OapiUserCreateRequest createRequest = convert(request, OapiUserCreateRequest.class);
        OapiUserCreateResponse response;
        try {
            response = execute(CREATE, createRequest);
        } catch (DingException e) {
            if (ContactsError.PHONE_IN_CORP_EXIST.eqErrCode(e)
                    && Objects.nonNull(e.getSource())
                    && e.getSource() instanceof OapiUserCreateResponse) {
                response = e.getSource();
            } else {
                throw e;
            }
        }

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
    public DingUserResponse get(String userId) throws DingException {
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
    public DingPage<DingUserSimpleResponse> simpleList(DingPageable pageable, Long deptId) throws DingException {
        Assert.notNull(deptId, "deptId 必输");

        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(deptId);
        request.setOffset((long) pageable.getOffset());
        request.setSize((long) pageable.getSize());
        request.setOrder(pageable.getOrder());

        OapiUserSimplelistResponse response = execute(SIMPLE_LIST, request);
        List<OapiUserSimplelistResponse.Userlist> userList = response.getUserlist();

        if (CollUtil.isEmpty(userList)) {
            return DingPage.empty();
        }
        List<DingUserSimpleResponse> list = userList.stream()
                .map(this::createDingUserSimpleResponse)
                .collect(Collectors.toList());

        return new DingPage<>(response.getHasMore(), list);
    }

    private DingUserSimpleResponse createDingUserSimpleResponse(OapiUserSimplelistResponse.Userlist userList) {
        return convert(userList, DingUserSimpleResponse.class);
    }

    @Override
    public DingPage<DingUserListResponse> listByPage(DingPageable pageable, Long deptId) throws DingException {
        Assert.notNull(deptId, "deptId 必输");
        Assert.notNull(pageable, "pageable 必输");

        OapiUserListbypageRequest request = new OapiUserListbypageRequest();
        request.setDepartmentId(deptId);
        request.setOffset((long) pageable.getOffset());
        request.setSize((long) pageable.getSize());
        request.setOrder(pageable.getOrder());
        request.setHttpMethod("GET");
        OapiUserListbypageResponse response = execute(LIST_BY_PAGE, request);
        List<OapiUserListbypageResponse.Userlist> userList = response.getUserlist();
        if (CollUtil.isEmpty(userList)) {
            return DingPage.empty();
        }
        List<DingUserListResponse> list = userList.stream()
                .map(this::createDingUserResponse)
                .collect(Collectors.toList());

        return new DingPage<>(response.getHasMore(), list);
    }

    private DingUserListResponse createDingUserResponse(OapiUserListbypageResponse.Userlist userList) {
        return convert(userList, DingUserListResponse.class);
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
    public DingPage<String> getInactive(DingPageable pageable, LocalDate queryDate) {
        Assert.notNull(pageable, "pageable 必输");
        Assert.notNull(queryDate, "queryDate 必输");

        OapiInactiveUserGetRequest request = new OapiInactiveUserGetRequest();
        // 分页偏移量
        request.setOffset((long) pageable.getOffset());
        // 每页size，最多100
        request.setSize((long) pageable.getSize());
        // 查询日期
        request.setQueryDate(DateTimeFormatter.BASIC_ISO_DATE.format(queryDate));
        OapiInactiveUserGetResponse response = execute(GET_INACTIVE_USER, request);

        OapiInactiveUserGetResponse.PageVo result = response.getResult();
        return new DingPage<>(result.getHasMore(), result.getList());
    }
}
