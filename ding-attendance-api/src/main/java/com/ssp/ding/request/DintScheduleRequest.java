package com.ssp.ding.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * 排班详情
 *
 * @author: sunshaoping
 * @date: Create by in 2:47 下午 2020/6/19
 */
@Getter
@Builder
public class DintScheduleRequest {

    /**
     * 是否休息；
     * <p>
     * true表示休息，shift_id传1
     */
    @JsonProperty("is_rest")
    private final Boolean isRest;
    /**
     * 班次id；休息班次传1
     */
    @JsonProperty("shift_id")
    private final Long shiftId;
    /**
     * 人员userid
     */
    @JsonProperty("userid")
    private final String userId;
    /**
     * 排班日期
     */
    @JsonProperty("work_date")
    private final Long workDate;


}
