package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingProcessInstanceCreateRequest;
import com.ssp.ding.request.DingProcessInstanceListIdsRequest;
import com.ssp.ding.request.GrantCspaceRequest;
import com.ssp.ding.response.DingCursorPage;
import com.ssp.ding.response.ProcessInstanceDetailResponse;

/**
 * 工作流实例
 *
 * <p>
 * 使用钉钉官方工作流(推荐)
 * <p>
 * 接口文档(接入必读):https://ding-doc.dingtalk.com/doc#/serverapi2/ca8r99
 *
 * @author: sunshaoping
 * @date: Create by in 4:56 下午 2020/6/17
 */
public interface DingProcessInstanceService {

    /**
     * 发起审批实例
     * <p>
     * 发起审批实例仅支持本文档中列出的表单控件，详见本文表单控件说明。
     * <p>
     * 根据是否指定审批人，发起审批实例分为2种方式：
     * <p>
     * 方式一 指定审批人
     * <p>
     * （1）调用接口时，传入approvers或者approvers_v2参数，指定审批人。其中，approvers_v2支持或签和会签。
     * <p>
     * （2）指定审批人方式，不支持审批模板的高级设置，比如手写签名、表单操作权限等均无法使用等。
     * <p>
     * 方式二 复用审批后台设置的审批流程
     * <p>
     * （1）调用接口时，不传入approvers或者approvers_v2参数，会自动复用在审批管理后台预设的审批人。流程设置页面见下图。
     * <p>
     * （2）可在流程设计里设置审批人的或签会签等操作。
     * <p>
     * （3）复用审批后台设置的审批流程时，若接口填写cc_list、cc_position，参数不生效，会复用审批后台设置的抄送人员。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/processinstance/create?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/cmct1a/k2HBI
     *
     * @param createRequest 实例数据
     * @return 审批实例id
     */
    String create(DingProcessInstanceCreateRequest createRequest) throws DingException;

    /**
     * 批量获取审批实例id
     * <p>
     * 企业使用此接口审批单发起时间在某时间段内的审批实例id列表。企业可以再根据审批实例id，调用获取审批实例详情接口，获取实例详情信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/processinstance/listids?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/hh8lx5
     *
     * @param pageable       分页
     * @param listIdsRequest 查询条件
     * @return 发起人用户id列表，最大列表长度：10
     */

    DingCursorPage<String> listIds(DingPageable pageable, DingProcessInstanceListIdsRequest listIdsRequest) throws DingException;

    /**
     * @see #listIds(DingPageable, DingProcessInstanceListIdsRequest)
     */
    default DingCursorPage<String> listIds(DingProcessInstanceListIdsRequest listIdsRequest) throws DingException {
        return listIds(DingPageable.DEFAULT_20, listIdsRequest);
    }

    /**
     * 获取审批实例详情
     * <p>
     * 根据审批实例id调用此接口获取审批实例详情，包括审批表单信息、操作记录列表、操作人、抄送人、审批任务列表等。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/processinstance/get?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/xgqkvx
     *
     * @param processInstanceId 审批实例id
     * @return 审批实例详情
     */
    ProcessInstanceDetailResponse get(String processInstanceId) throws DingException;


    /**
     * 获取审批钉盘空间信息
     * <p>
     * 获取审批钉盘空间信息接口，需结合前端API“上传附件到钉盘”使用，使用方法如下：
     * <p>
     * （1）调用本文介绍的“获取审批钉盘空间信息”接口，获取钉盘控件的上传权限，并获取space_id
     * <p>
     * （2）使用参数space_id，调用“H5微应用-JSAPI-上传附件到钉盘”或“小程序-上传附件到钉盘”后，获取钉盘附件的信息
     * <p>
     * （3）调用发起审批实例接口，传递附件信息
     *
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/processinstance/cspace/info?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/xq6ml3
     *
     * @param userId 用户id
     * @return 审批钉盘空间id
     */
    Long cspaceInfo(String userId) throws DingException;

    /**
     * 预览审批附件
     * <p>
     * 此接口需配合钉盘JSAPI使用，实现在企业应用内预览、下载审批附件的功能。使用方法如下：
     * <p>
     * （1）调用本文接口，授权用户预览、下载审批附件，获取到space_id。每一次预览审批附件前，都需要调用该接口进行授权。
     * <p>
     * （2）使用参数space_id，调用“H5微应用-JSAPI-预览钉盘文件”或“小程序-钉盘文件预览”后，获取钉盘附件的信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/processinstance/cspace/preview?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/sg687u
     *
     * @param cspaceRequest 预览审批数据
     */
    void cspacePreview(GrantCspaceRequest cspaceRequest) throws DingException;


}
