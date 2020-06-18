package com.ssp.ding;

import com.ssp.ding.exception.DingException;
import com.ssp.ding.request.DingExtCreateContactRequest;
import com.ssp.ding.request.DingExtUpdateContactRequest;
import com.ssp.ding.request.DingPageable;
import com.ssp.ding.response.DingExtContactResponse;
import com.ssp.ding.response.LabelGroupResponse;

import java.util.List;

/**
 * 外部联系人管理
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa
 *
 * @author: sunshaoping
 * @date: Create by in 7:36 下午 2020/6/10
 */
public interface DingExtContactService {

    /**
     * 添加外部联系人
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa/6ed7f91b
     */
    String create(DingExtCreateContactRequest request) throws DingException;

    /**
     * 更新外部联系人
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa/b08f964c
     */
    void update(String userId, DingExtUpdateContactRequest request) throws DingException;

    /**
     * 删除外部联系人
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa/5d33a560
     */
    void delete(String userId) throws DingException;


    /**
     * 获取外部联系人详情
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa/b1e30673
     *
     * @param userId 用户id 必输
     */
    DingExtContactResponse get(String userId) throws DingException;

    /**
     * 获取外部联系人列表
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa/b4ff3cbf
     *
     * @param pageable 分页
     */
    List<DingExtContactResponse> list(DingPageable pageable) throws DingException;

    /**
     * @see #list(DingPageable)
     */
    default List<DingExtContactResponse> list() throws DingException {
        return list(DingPageable.DEFAULT);
    }

    /**
     * 获取外部联系人标签列表
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/nb93oa/063e4bde
     */
    List<LabelGroupResponse> listLabelGroups(DingPageable pageable) throws DingException;

    /**
     * @see #listLabelGroups(DingPageable)
     */
    default List<LabelGroupResponse> listLabelGroups() throws DingException {
        return listLabelGroups(DingPageable.DEFAULT);
    }


}
