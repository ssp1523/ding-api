package com.ssp.ding.handler;

/**
 * 钉钉回调处理类
 * <p>
 * 概述:https://ding-doc.dingtalk.com/doc#/serverapi2/skn8ld
 *
 * @author: sunshaoping
 * @date: Create by in 3:33 下午 2020/6/19
 */
public interface DingCallbackHandler<T extends CallbackEvent> {


    /**
     * 第一步:是否支持指定事件类型
     *
     * @param eventType 钉钉事件类型
     * @return true:支持,并调用{@link #callback(CallbackEvent)}方法,false不支持,跳过该handler
     */
    boolean support(String eventType);

    /**
     * 第二步:返回解析json的class对象,该class继承 {@link CallbackEvent} 接口
     *
     * @return 继承 {@link CallbackEvent}的class 对象
     */
    Class<T> parseJsonClass();

    /**
     * 根据json字符串解析
     * 如果 {@link #parseJsonClass()} 返回 null 或解析错误,调用该方法
     *
     * @param json json字符串
     * @return 解析后的对象
     */
    default T parseJson(String json) {
        throw new UnsupportedOperationException();
    }

    /**
     * 第三步:开始钉钉回调
     *
     * @param event 事件对象,{@link #parseJsonClass()  } 返回null, 该参数也是null,否则是json解析后的对象
     */
    void callback(T event);

}
