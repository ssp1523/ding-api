package com.ssp.ding.response.auth;

import lombok.Data;

/**
 * 授权方企业信息
 * @author: sunshaoping
 * @date: Create by in 2:40 下午 2020/6/7
 */
@Data
public class AuthCorpInfo {

    private String authChannel;
    private String authChannelType;
    private Long authLevel;
    private String belongCorpId;
    private String corpLogoUrl;
    private String corpName;
    private String corpid;
    private String industry;
    private String inviteCode;
    private String inviteUrl;
    private Boolean isAuthenticated;
    private String licenseCode;
    private String unifiedSocialCredit;


}
