package com.ssp.ding.enumeration;

import lombok.Getter;

/**
 * 激活钉钉
 * 0表示包含未激活钉钉的人员数量
 * 1表示不包含未激活钉钉的人员数量
 *
 * @author: sunshaoping
 * @date: Create by in 4:13 下午 2020/6/7
 */
@Getter
public enum OnlyActive {

    /**
     * 包含未激活钉钉的人员数量
     */
    NOT_ACTIVE(0),
    /**
     * 不包含未激活钉钉的人员数量
     */
    ACTIVE(1);

    private final Integer type;

    OnlyActive(Integer type) {
        this.type = type;
    }
}
