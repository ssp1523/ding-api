package com.ssp.ding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.message.DingMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * jackson json序列化
 *
 * @author: sunshaoping
 * @date: Create by in 5:32 下午 2020/6/24
 */
public class JacksonDingMessageSender<T> extends DefaultDingMessageSender<T> {

    private final ObjectMapper objectMapper;

    private final Function<String, T> function;

    public JacksonDingMessageSender(ObjectMapper objectMapper, Function<String, T> function) {
        this.objectMapper = objectMapper;
        this.function = function;
    }


    @Override
    public T sendMessage(DingMessage message) {
        try {
            Map<String, Object> map = new HashMap<>();
            String type = message.getMsgType().getType();
            map.put("msgtype", type);
            map.put(type, message);
            String json = objectMapper.writeValueAsString(map);
            return function.apply(json);
        } catch (JsonProcessingException e) {
            throw new DingException(e.getMessage(), e);
        }
    }

}
