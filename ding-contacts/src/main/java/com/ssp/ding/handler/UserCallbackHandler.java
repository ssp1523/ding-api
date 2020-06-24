package com.ssp.ding.handler;

import com.ssp.ding.event.DingUserCallbackEvent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 用户回调处理
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/tvgq1n
 *
 * @author: sunshaoping
 * @date: Create by in 3:49 下午 2020/6/19
 */
@Slf4j
public abstract class UserCallbackHandler implements DingCallbackHandler<DingUserCallbackEvent> {


    /**
     * 通讯录用户增加
     */
    public static final String USER_ADD_ORG = "user_add_org";
    /**
     * 通讯录用户更改
     */
    public static final String USER_MODIFY_ORG = "user_modify_org";

    /**
     * 通讯录用户离职
     */
    public static final String USER_LEAVE_ORG = "user_leave_org";

    /**
     * 加入企业后用户激活
     */
    public static final String USER_ACTIVE_ORG = "user_active_org";

    /**
     * 通讯录用户被设为管理员
     */

    public static final String ORG_ADMIN_ADD = "org_admin_add";

    /**
     * 通讯录用户被取消设置管理员
     */
    public static final String ORG_ADMIN_REMOVE = "org_admin_remove";


    @Nullable
    @Override
    public Class<DingUserCallbackEvent> parseJsonClass() {
        return DingUserCallbackEvent.class;
    }

    @Override
    public void callback(DingUserCallbackEvent event) {
        callback(event.getEventType(), event.getUserIds());

    }


    /**
     * @param eventType 事件类型
     * @param userIds   用户发生变更的userid列表
     */
    protected abstract void callback(String eventType, List<String> userIds);

}
