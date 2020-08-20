package com.ssp.ding.convert;

import com.dingtalk.api.request.OapiChatCreateRequest;
import com.ssp.ding.request.DingChatCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import static com.ssp.ding.utils.NumberConvertUtils.toLong;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
public class OapiChatCreateRequestConverter implements Converter<DingChatCreateRequest, OapiChatCreateRequest> {


    @Override
    public OapiChatCreateRequest convert(DingChatCreateRequest source) {

        OapiChatCreateRequest request = new OapiChatCreateRequest();
        request.setChatBannedType(toLong(source.getChatBannedType()));
        request.setIcon(source.getIcon());
        request.setManagementType(toLong(source.getManagementType()));
        request.setMentionAllAuthority(toLong(source.getMentionAllAuthority()));
        request.setName(source.getName());
        request.setOwner(source.getOwner());
        request.setSearchable(toLong(source.getSearchable()));
        request.setShowHistoryType(toLong(source.getShowHistoryType()));
        request.setUseridlist(source.getUserIdList());
        request.setValidationType(toLong(source.getValidationType()));

        return request;
    }
}
