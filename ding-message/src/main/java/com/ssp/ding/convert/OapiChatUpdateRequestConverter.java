package com.ssp.ding.convert;

import com.dingtalk.api.request.OapiChatUpdateRequest;
import com.ssp.ding.request.DingChatUpdateRequest;
import org.springframework.core.convert.converter.Converter;

import static com.ssp.ding.utils.NumberConvertUtils.toLong;

/**
 * @author: sunshaoping
 * @date: Create by in 10:15 上午 2020/7/3
 */
public class OapiChatUpdateRequestConverter implements Converter<DingChatUpdateRequest, OapiChatUpdateRequest> {

    @Override
    public OapiChatUpdateRequest convert(DingChatUpdateRequest source) {

        OapiChatUpdateRequest updateRequest = new OapiChatUpdateRequest();
        updateRequest.setAddUseridlist(source.getAddUserIdList());
        updateRequest.setChatBannedType(toLong(source.getChatBannedType()));
        updateRequest.setDelUseridlist(source.getDelUserIdList());
        updateRequest.setIcon(source.getIcon());
        updateRequest.setManagementType(toLong(source.getManagementType()));
        updateRequest.setMentionAllAuthority(toLong(source.getMentionAllAuthority()));
        updateRequest.setName(source.getName());
        updateRequest.setOwner(source.getOwner());
        updateRequest.setSearchable(toLong(source.getSearchable()));
        updateRequest.setShowHistoryType(toLong(source.getShowHistoryType()));
        updateRequest.setValidationType(toLong(source.getValidationType()));

        return updateRequest;
    }
}
