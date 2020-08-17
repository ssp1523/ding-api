package com.ssp.ding;

import com.ssp.ding.enumeration.MediaType;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.response.DingMediaResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.InputStream;

/**
 * 上传媒体文件
 * 该接口只提供了上传媒体文档相关方法
 * 如果需要上传媒体文件并发送消息通知请使用{@link DingMediaMessageService}接口
 * <p>
 * 接口文档:https://ding-doc.dingtalk.com/doc#/serverapi2/bcmg0i
 * <p>
 * 请求地址：https://oapi.dingtalk.com/media/upload?access_token=ACCESS_TOKEN&type=TYPE
 *
 * @author: sunshaoping
 * @date: Create by in 10:30 上午 2020/6/16
 * @see DingMediaMessageService
 * @see DingMessageService
 */
public interface DingMediaService {

    /**
     * 上传媒体文件
     * 用于上传图片、语音等媒体资源文件以及普通文件（如doc、ppt），接口返回媒体资源标识media_id。请注意：
     * （1）media_id是可复用的，同一个media_id多次使用。
     * （2）media_id对应的资源文件，仅能在钉钉客户端内使用。
     *
     * @param mediaType 媒体类型
     * @param resource  上传资源 spring项目使用
     */
    DingMediaResponse upload(MediaType mediaType, Resource resource) throws DingException;

    /**
     * 上传媒体文件
     * 用于上传图片、语音等媒体资源文件以及普通文件（如doc、ppt），接口返回媒体资源标识media_id。请注意：
     * （1）media_id是可复用的，同一个media_id多次使用。
     * （2）media_id对应的资源文件，仅能在钉钉客户端内使用。
     *
     * @param mediaType   媒体类型
     * @param fileName    文件名
     * @param inputStream 文件字节流
     */
    DingMediaResponse upload(MediaType mediaType, String fileName, InputStream inputStream) throws DingException;

    /**
     * 上传媒体文件
     * 用于上传图片、语音等媒体资源文件以及普通文件（如doc、ppt），接口返回媒体资源标识media_id。请注意：
     * （1）media_id是可复用的，同一个media_id多次使用。
     * （2）media_id对应的资源文件，仅能在钉钉客户端内使用。
     *
     * @param mediaType 媒体类型
     * @param file      本地文件
     */
    DingMediaResponse upload(MediaType mediaType, File file) throws DingException;

    /**
     * 上传媒体文件
     * 用于上传图片、语音等媒体资源文件以及普通文件（如doc、ppt），接口返回媒体资源标识media_id。请注意：
     * （1）media_id是可复用的，同一个media_id多次使用。
     * （2）media_id对应的资源文件，仅能在钉钉客户端内使用。
     *
     * @param mediaType 媒体类型
     * @param fileName  文件名
     * @param content   文件字节数组
     */
    DingMediaResponse upload(MediaType mediaType, String fileName, byte[] content) throws DingException;


    /**
     * 接口api
     */
    @Getter
    @RequiredArgsConstructor
    enum Api implements DingApi {

        /**
         * @see DingMediaService
         */
        UPLOAD("/media/upload", "上传媒体文件"),
        ;

        private final String path;

        private final String sketch;

    }
}
