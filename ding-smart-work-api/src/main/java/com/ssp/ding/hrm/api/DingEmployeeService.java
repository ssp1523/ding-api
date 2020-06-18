package com.ssp.ding.hrm.api;

import com.ssp.ding.hrm.request.DingGroupMetaInfoRequest;
import com.ssp.ding.hrm.request.DingPreEntryEmployeeRequest;
import com.ssp.ding.hrm.response.DingEmployeeDimissionResponse;
import com.ssp.ding.hrm.response.DingEmpFieldGroupResponse;
import com.ssp.ding.hrm.response.DingEmpResponse;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.response.DingCursorPage;

import java.util.List;

/**
 * 花名册
 * <p>
 * 案例说明:https://ding-doc.dingtalk.com/doc#/serverapi2/okl9kn
 * <p>
 * 权限说明:https://ding-doc.dingtalk.com/doc#/serverapi2/dt96kf
 *
 * @author: sunshaoping
 * @date: Create by in 1:34 下午 2020/6/18
 */
public interface DingEmployeeService {

    /**
     * 获取员工花名册字段信息
     * <p>
     * 根据员工userid，批量获取员工花名册字段信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/list?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/rikq4i
     *
     * @param userIdList      员工userid列表，最大列表长度：20
     * @param fieldFilterList 需要获取的花名册字段列表，最大列表长度：20。具体业务字段的code参见附录（大小写敏感）。不传入该参数时，企业可获取所有字段信息。
     * @return 员工花名册信息结果列表
     */
    List<DingEmpResponse> list(List<String> userIdList, List<String> fieldFilterList);


    /**
     * 更新员工花名册
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/update?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/aw6wuy
     *
     * @param agentId 微应用在企业的AgentId
     * @param userId  用户在企业的唯一标识
     * @param groups  组明细
     */
    void update(Long agentId, String userId, List<DingGroupMetaInfoRequest> groups);


    /**
     * 查询花名册元数据
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/field/grouplist?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/beo741
     *
     * @param agentId 应用agentid
     * @return 员工花名册信息结果
     */
    List<DingEmpFieldGroupResponse> groupList(Long agentId);


    /**
     * 查询企业待入职员工列表
     * <p>
     * 分页查询企业待入职员工userid列表。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/querypreentry?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/yv3mcy
     *
     * @param pageable 分页
     * @return 员工userid列表
     */
    DingCursorPage<String> queryPreEntry(DingPageable pageable);


    /**
     * 查询企业在职员工列表
     * <p>
     * 分页查询企业在职员工userid列表。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/queryonjob?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/rafx8t
     *
     * @param pageable   分页
     * @param statusList 在职员工子状态筛选，其他状态无效。2:试用期；3:正式；5:待离职；-1:无状态。
     * @return 员工userid列表
     */
    DingCursorPage<String> queryOnJob(DingPageable pageable, List<Integer> statusList);


    /**
     * 查询企业离职员工列表
     * <p>
     * 分页查询企业离职员工userid列表。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/querydimission?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/oe0nlx
     *
     * @param pageable 分页
     * @return 离职员工userid列表
     */
    DingCursorPage<String> queryDimission(DingPageable pageable);


    /**
     * 获取离职员工离职信息
     * <p>
     * 根据员工userid列表，批量查询员工的离职信息。如果传入为非离职员工userid，不会返回信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/listdimission?access_token=ACCESS_TOKEN
     * <p>
     * 接口地址:https://ding-doc.dingtalk.com/doc#/serverapi2/fbtugn
     *
     * @param userIdList 员工userid列表，最大长度50
     * @return 员工离职信息列表
     */
    List<DingEmployeeDimissionResponse> listDimission(List<String> userIdList);


    /**
     * 添加企业待入职员工
     * <p>
     * 此接口用于添加人员到企业待入职，并不同步员工详细档案信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/smartwork/hrm/employee/addpreentry?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/dhlu4d
     *
     * @param request 添加待入职入参
     * @return 创建成功后，返回的员工唯一标识ID
     */
    String addPreEntry(DingPreEntryEmployeeRequest request);
}
