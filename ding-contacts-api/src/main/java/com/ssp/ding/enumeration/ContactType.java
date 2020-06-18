package com.ssp.ding.enumeration;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

/**
 * 联系类型,0表示企业内部员工，1表示企业外部联系人
 *
 * @author: sunshaoping
 * @date: Create by in 4:17 下午 2020/6/7
 */
@Getter
public enum ContactType {
    /**
     * 0表示企业内部员工
     */
    INTERNAL(0),
    /**
     * 1表示企业外部联系人
     */
    EXTERNAL(1);


    private final Integer type;


    ContactType(Integer type) {
        this.type = type;
    }

    public static ContactType valueOf(Long type) {
        if (ObjectUtil.isEmpty(type)) {
            return null;
        }
        if (ContactType.EXTERNAL.type.equals(Math.toIntExact(type))) {
            return ContactType.EXTERNAL;
        }
        if (ContactType.INTERNAL.type.equals(Math.toIntExact(type))) {
            return ContactType.INTERNAL;
        }
        return null;
    }

}
