package com.ssp.ding.handler;

import com.ssp.ding.event.DingRoleCallbackEvent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 角色回调处理
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/tvgq1n
 *
 * @author: sunshaoping
 * @date: Create by in 3:49 下午 2020/6/19
 */
@Slf4j
public abstract class RoleCallbackHandler implements DingCallbackHandler<DingRoleCallbackEvent> {
    /**
     * 员工角色信息发生变更
     */
    public static final String LABEL_USER_CHANGE = "label_user_change";
    /**
     * 增加角色或者角色组
     */
    public static final String LABEL_CONF_ADD = "label_conf_add";

    /**
     * 删除角色或者角色组
     */
    public static final String LABEL_CONF_DEL = "label_conf_del";
    /**
     * 修改角色或者角色组
     */
    public static final String LABEL_CONF_MODIFY = "label_conf_modify";


    @Nullable
    @Override
    public Class<DingRoleCallbackEvent> parseJsonClass() {
        return DingRoleCallbackEvent.class;
    }

    @Override
    public void callback(DingRoleCallbackEvent event) {
        roleCallback(event.getEventType(), event.getRoleIds());
    }

    /**
     * @param eventType 事件类型
     * @param roleIds   角色发生变更的roleId列表
     */
    protected abstract void roleCallback(String eventType, List<Long> roleIds);

}
