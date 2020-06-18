package com.ssp.ding.response;

import com.ssp.ding.enumeration.ContactType;
import lombok.Data;

/**
 * userid 信息
 *
 * @author: sunshaoping
 * @date: Create by in 4:07 下午 2020/6/7
 */
@Data
public class UserIdResponse {
    /**
     * 联系类型，0表示企业内部员工，1表示企业外部联系人
     */
    private ContactType contactType;
    /**
     * 员工id
     */
    private String userId;

}
