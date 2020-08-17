package com.ssp.ding;

import com.ssp.ding.request.DingPageable;
import com.ssp.ding.request.DingSaveProcessRequest;
import com.ssp.ding.response.DingCursorPage;
import com.ssp.ding.response.DingProcessTopResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nullable;

/**
 * 企业自有工作流模板
 * <p>
 * 企业内部应用可以调用钉钉开放平台的智能工作流接口，将工作流数据同步到钉钉，为企业提供了统一的工作流处理入口
 * <p>
 * 接入必读:https://ding-doc.dingtalk.com/doc#/serverapi2/civf9v
 *
 * @author: sunshaoping
 * @date: Create by in 11:27 上午 2020/6/17
 */
public interface DingProcessService {


    /**
     * 创建模板
     * <p>
     * 注意:
     * <p>
     * 官网api接口文档创建和更新是同一个接口,
     * 此处将其分为两个接口,如需更新处理请调用{@link #update(String, DingSaveProcessRequest) 更新模板接口}
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/save?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/xcgg03/HdrHh
     *
     * @return 模板的唯一码
     * @see #update(String, DingSaveProcessRequest)  更新模板
     */
    String create(DingSaveProcessRequest request);

    /**
     * 更新模板
     * <p>
     * 注意:
     * <p>
     * 官网api接口文档创建和更新是同一个接口,
     * 此处将其分为两个接口,如需更新处理请调用{@link #create(DingSaveProcessRequest)}  创建模板接口}
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/save?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/xcgg03/HdrHh
     *
     * @param processCode 模板的唯一码
     * @param request     更新内容
     * @see #create(DingSaveProcessRequest) 创建模板
     */
    void update(String processCode, DingSaveProcessRequest request);


    /**
     * 获取模板code
     * <p>
     * 调用此接口可以根据模板名称查询process_code。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/get_by_name?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/uts09n
     *
     * @param name 模板名称
     * @return 模板code
     */
    String getByName(String name);

    /**
     * 获取用户待审批数量
     * <p>
     * 调用此接口可以获取用户待处理的审批数量。开发者可以通过以下链接，
     * 使用<a href="https://ding-doc.dingtalk.com/doc#/dev/lml9h2/kxaviz">H5微应用JSAPI-在新窗口上打开链接</a>跳转到钉钉审批移动端微应用（暂不支持PC端）的待我审批页面：
     * https://aflow.dingtalk.com/dingtalk/mobile/homepage.htm?showmenu=false&dd_share=false&corpid=$CORPID#/upcoming?swfrom=work_homepage
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/gettodonum?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ui5305
     *
     * @param userId 用户id
     * @return 待审批数量
     */
    Integer getTodoNum(String userId);

    /**
     * 获取用户可见的审批模板
     * <p>
     * 调用此接口，可以获取用户可见的审批模板
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/listbyuserid?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/tcwmha
     *
     * @param pageable 分页
     * @param userId   用户id,不传的话表示获取企业的所有模板
     * @return 审批模板列表
     */
    DingCursorPage<DingProcessTopResponse> listByUserId(DingPageable pageable, String userId);

    /**
     * @see #listByUserId(DingPageable, String)
     */
    default DingCursorPage<DingProcessTopResponse> listByUserId(String userId) {
        return listByUserId(DingPageable.DEFAULT_20, userId);
    }

    /**
     * @see #delete(Long, String, Boolean)
     */
    default void delete(String processCode) {
        delete(null, processCode, false);
    }

    /**
     * 删除模板
     * <p>
     * 企业调用此接口可以删除为企业创建的工作流模板，同时删除该模板下创建的实例和待办任务。
     * <p>
     * 请求地址：https://oapi.dingtalk.com/topapi/process/delete?access_token=ACCESS_TOKEN
     * <p>
     * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/ilni1r
     *
     * @param agentId          企业应用标识
     * @param processCode      模板的唯一码
     * @param cleanRunningTask 是否清理运行中的任务，不传默认为false
     */
    void delete(@Nullable Long agentId, String processCode, @Nullable Boolean cleanRunningTask);


    /**
     * 接口枚举
     *
     * @author: sunshaoping
     * @date: Create by in 4:20 下午 2020/8/13
     */
    @Getter
    @RequiredArgsConstructor
    enum Api implements DingApi {


        /**
         * @see #update(String, DingSaveProcessRequest)
         * @see #create(DingSaveProcessRequest)
         */
        SAVE("/topapi/process/save", "创建/更新模板"),

        /**
         * @see #getByName(String)
         */
        GET_BY_NAME("/topapi/process/get_by_name", "获取模板code"),

        /**
         * @see #getTodoNum(String)
         */
        GET_TODO_NUM("/topapi/process/gettodonum", "获取用户待审批数量"),

        /**
         * @see #listByUserId(DingPageable, String)
         */
        LIST_BY_USER_ID("/topapi/process/listbyuserid", "获取用户可见的审批模板"),

        /**
         * @see #delete(Long, String, Boolean)
         * @see #delete(java.lang.String)
         */
        DELETE("/topapi/process/delete", "删除模板"),

        ;

        private final String path;

        private final String sketch;


    }
}
