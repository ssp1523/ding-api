package com.ssp.ding.response;

import lombok.Builder;
import lombok.Data;

/**
 * 用户userId信息
 *
 * @author: sunshaoping
 * @date: Create by in 5:08 下午 2020/6/15
 */
@Data
@Builder
public class DingUserInfoResponse {
    /**
     * 是否是管理员，true：是，false：不是
     */
    private Boolean isSys;
    /**
     * 级别。1是主管理员，2是子管理员，100是老板，0是其他（如普通员工）
     */
    private String sysLevel;
    /**
     * 员工在当前企业内的唯一标识，也称staffId
     */
    private String userId;

}
