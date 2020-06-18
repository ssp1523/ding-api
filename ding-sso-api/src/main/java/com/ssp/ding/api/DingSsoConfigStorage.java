package com.ssp.ding.api;

/**
 * TODO 记得写注释
 *
 * @author: sunshaoping
 * @date: Create by in 5:25 下午 2020/6/15
 */
public interface DingSsoConfigStorage {
    /**
     * 企业Id
     */
    String getCorpId();

    /**
     * 这里必须填写专属的SSOsecret
     */
    String getCorpSecret();
}
