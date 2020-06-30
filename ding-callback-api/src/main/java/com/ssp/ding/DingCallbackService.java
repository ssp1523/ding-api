package com.ssp.ding;

import com.ssp.ding.handler.CallbackEvent;
import com.ssp.ding.handler.DingCallbackHandler;

import java.util.Map;

/**
 * 事件回调处理
 *
 * @author: sunshaoping
 * @date: Create by in 4:32 下午 2020/6/23
 */
public interface DingCallbackService {

    /**
     * 注册钉钉回调处理
     *
     * @param handler 回调处理
     */
    void registerCallBackHandler(DingCallbackHandler<? extends CallbackEvent> handler);

    /**
     * 解密
     *
     * @param signature   签名
     * @param timestamp   时间戳
     * @param nonce       随机字符串
     * @param encryptJson 加密数据json
     * @return encryptJson 解密后的json字符串
     */
    String decrypt(String signature, String timestamp, String nonce, String encryptJson);

    /**
     * 开始回调
     *
     * @param plainText encryptJson 解密后的json字符串
     * @return 响应数据, 直接以json格式返回给钉钉即可
     */
    Map<String, String> callback(String plainText);


    /**
     * 事件回调
     *
     * @param signature   签名
     * @param timestamp   时间戳
     * @param nonce       随机字符串
     * @param encryptJson 加密数据json
     * @return 响应数据, 直接以json格式返回给钉钉即可
     */
    Map<String, String> decryptAndParseCallback(String signature, String timestamp, String nonce, String encryptJson);
}
