package com.ssp.ding.api.response;

import lombok.Data;

/**
 * 公司信息
 *
 * @author: sunshaoping
 * @date: Create by in 5:32 下午 2020/6/15
 */
@Data
public class CorpInfoResponse {
    /**
     * 公司名字
     */
    private String corpName;
    /**
     * 公司corpid
     */
    private String corpId;
}
