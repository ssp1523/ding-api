package com.ssp.ding;

import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingScheduleUserRequest;
import com.ssp.ding.request.DintScheduleRequest;
import com.ssp.ding.response.DingPage;
import com.ssp.ding.response.DingScheduleDayResponse;
import com.ssp.ding.response.DingScheduleResponse;
import com.ssp.ding.response.DingScheduleUserResponse;

import java.time.LocalDate;
import java.util.List;

/**
 * 考勤排班
 *
 * @author: sunshaoping
 * @date: Create by in 3:16 下午 2020/6/18
 */
public interface DingScheduleService {

    /**
     * 查询企业考勤排班详情
     * <p>
     * 在钉钉考勤应用中，设置考勤组规则后，会生成每天的排班信息，包括工作日、周末、节假日等。如果企业想查询某天的排班情况，可使用此接口查询某天的考勤排班全量信息。
     * <p>
     * 注：固定班制只能查到未来15天的排班信息。接口仅支持企业总人数10000人以下使用
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/attendance/listschedule?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ufc8dl/mRr12
     *
     * @param pageable 分页信息
     * @param workDate 排班时间
     * @return 排班列表
     */
    DingPage<DingScheduleResponse> listSchedule(DingPageable pageable, LocalDate workDate);


    /**
     * 查询成员排班信息
     * <p>
     * 查询某人在某工作日的排班信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/attendance/schedule/listbyday?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ufc8dl/7oC7C
     *
     * @param opUserId 操作人userId
     * @param userId   用户userId
     * @param dateTime 查询某个工作日的数据
     * @return 某个工作日的排班信息列表
     */
    List<DingScheduleDayResponse> listByDay(String opUserId, String userId, LocalDate dateTime);

    //

    /**
     * 批量查询成员排班信息
     * <p>
     * 查询批量人员的在工作日内的排班信息。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/attendance/schedule/listbyusers?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档: https://ding-doc.dingtalk.com/doc#/serverapi2/ufc8dl/q86hb
     */
    List<DingScheduleUserResponse> listByUsers(DingScheduleUserRequest request);


    //

    /**
     * 排班制考勤组排班
     * <p>
     * 给排班制考勤组成员进行排班
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/attendance/group/schedule/async?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ufc8dl/UtawV
     *
     * @param opUserId  操作人userId
     * @param groupId   考勤组id
     * @param schedules 排班详情列表
     */
    void scheduleAsync(String opUserId, Long groupId, List<DintScheduleRequest> schedules);

//    请求地址：https://oapi.dingtalk.com/topapi/attendance/schedule/result/listbyids?access_token=ACCESS_TOKEN


}
