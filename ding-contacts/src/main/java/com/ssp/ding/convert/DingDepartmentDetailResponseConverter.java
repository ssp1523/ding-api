package com.ssp.ding.convert;

import cn.hutool.core.collection.CollUtil;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.ssp.ding.response.DingDepartmentDetailResponse;
import com.ssp.ding.utils.NumberConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

import static cn.hutool.core.util.StrUtil.splitTrim;
import static com.ssp.ding.conf.DingConf.VERTICAL_BAR;

/**
 * DingUserResponse 转换器
 *
 * @author: sunshaoping
 * @date: Create by in 11:15 上午 2020/6/8
 */
@Slf4j
public class DingDepartmentDetailResponseConverter implements Converter<OapiDepartmentGetResponse, DingDepartmentDetailResponse> {


    @Override
    public DingDepartmentDetailResponse convert(OapiDepartmentGetResponse source) {

        List<String> list = split(source.getDeptPermits());
        List<Long> deptPermits = null;
        if (CollUtil.isNotEmpty(list)) {
            deptPermits = list.stream()
                    .map(Long::valueOf)
                    .collect(Collectors.toList());

        }
        List<String> outPermitDeptList = split(source.getOuterPermitDepts());
        List<Long> outerPermitDepts = null;
        if (CollUtil.isNotEmpty(outPermitDeptList)) {
            outerPermitDepts =
                    outPermitDeptList.stream()
                            .map(Long::valueOf)
                            .collect(Collectors.toList());
        }


        return DingDepartmentDetailResponse.builder()
                .autoAddUser(source.getAutoAddUser())
                .createDeptGroup(source.getCreateDeptGroup())
                .deptHiding(source.getDeptHiding())
                .deptManagerUserIdList(split(source.getDeptManagerUseridList()))
                .deptPermits(deptPermits)
                .groupContainSubDept(source.getGroupContainSubDept())
                .id(source.getId())
                .name(source.getName())
                .order(NumberConvertUtils.toLong(source.getOrder()))
                .orgDeptOwner(source.getOrgDeptOwner())
                .outerDept(source.getOuterDept())
                .outerPermitDepts(outerPermitDepts)
                .outerPermitUsers(split(source.getOuterPermitUsers()))
                .parentId(source.getParentid())
                .sourceIdentifier(source.getSourceIdentifier())
                .userPermits(split(source.getUserPermits()))
                .build();
    }

    private List<String> split(String strings) {
        return splitTrim(strings, VERTICAL_BAR);
    }
}
