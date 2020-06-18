package com.ssp.ding.request;

import com.ssp.ding.FormItem;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 待办事项
 *
 * @author: sunshaoping
 * @date: Create by in 10:54 上午 2020/6/18
 */
@Getter
@Builder
public class DingWorkRecordRequest {
    /**
     * 待办事项对应的用户id
     */
    private final String userId;
    /**
     * 外部业务id，建议带上业务方来源字段，防止与其他业务方冲突
     */
    @Nullable
    private final String bizId;
    /**
     * 待办时间
     */
    private final LocalDateTime createTime;
    /**
     * 待办事项表单
     */
    private final List<FormItem> formItemList;
    /**
     * 待办来源名称
     */
    @Nullable
    private final String sourceName;
    /**
     * 待办的pc打开方式。2表示在pc端打开，4表示在浏览器打开
     */
    @Nullable
    private final Integer pcOpenType;
    /**
     * pc端跳转url，不传则使用url参数
     */
    @Nullable
    private final String pcUrl;
    /**
     * 待办事项的标题，最多50个字符
     */
    private final String title;
    /**
     * 待办事项的跳转链接
     */
    private final String url;

}
