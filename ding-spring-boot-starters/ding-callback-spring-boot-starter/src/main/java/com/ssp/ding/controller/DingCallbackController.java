package com.ssp.ding.controller;

import com.ssp.ding.DingCallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 钉钉回调Controller
 *
 * @author: sunshaoping
 * @date: Create by in 4:49 下午 2020/8/20
 */
@RestController
@RequiredArgsConstructor
public class DingCallbackController {

    private final DingCallbackService callbackService;


    /**
     * 回调事件
     *
     * @param signature 消息体签名
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @param json      加密内容
     * @return 成功或失败的
     */
    @PostMapping("/ding/callback")
    public Map<String, String> callback(@RequestParam(value = "signature", required = false) String signature,
                                        @RequestParam(value = "timestamp", required = false) String timestamp,
                                        @RequestParam(value = "nonce", required = false) String nonce,
                                        @RequestBody(required = false) String json) {

        return callbackService.decryptAndParseCallback(signature, timestamp, nonce, json);
    }


}
