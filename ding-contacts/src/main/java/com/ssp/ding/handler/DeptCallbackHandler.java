package com.ssp.ding.handler;

import com.ssp.ding.event.DeptCallbackEvent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 部门回调处理
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/tvgq1n
 *
 * @author: sunshaoping
 * @date: Create by in 3:49 下午 2020/6/19
 */
@Slf4j
public abstract class DeptCallbackHandler implements DingCallbackHandler<DeptCallbackEvent> {
    /**
     * 通讯录企业部门创建
     */
    public static final String ORG_DEPT_CREATE = "org_dept_create";

    /**
     * 通讯录企业部门修改
     */
    public static final String ORG_DEPT_MODIFY = "org_dept_modify";

    /**
     * 通讯录企业部门删除
     */
    public static final String ORG_DEPT_REMOVE = "org_dept_remove";

    @Nullable
    @Override
    public Class<DeptCallbackEvent> parseJsonClass() {
        return DeptCallbackEvent.class;
    }

    @Override
    public void callback(DeptCallbackEvent event) {
        deptCallback(event.getEventType(), event.getDeptIds());
    }

    /**
     * @param eventType 事件类型
     * @param deptIds   部门发生变更的deptId列表
     */
    protected abstract void deptCallback(String eventType, List<Long> deptIds);

}
