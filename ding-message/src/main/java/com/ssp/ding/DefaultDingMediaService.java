package com.ssp.ding;

import cn.hutool.core.util.ObjectUtil;
import com.dingtalk.api.request.OapiMediaUploadRequest;
import com.dingtalk.api.response.OapiMediaUploadResponse;
import com.ssp.ding.enumeration.MediaType;
import com.ssp.ding.exception.DingException;
import com.ssp.ding.response.DingMediaResponse;
import com.ssp.ding.service.BaseDingService;
import com.ssp.ding.service.DingClient;
import com.taobao.api.FileItem;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 文件上传实现
 *
 * @author: sunshaoping
 * @date: Create by in 4:36 下午 2020/6/24
 */
public class DefaultDingMediaService extends BaseDingService implements DingMediaService {


    protected DefaultDingMediaService(DingClient dingClient) {
        super(dingClient, null);
    }

    @Override
    public DingMediaResponse upload(MediaType mediaType, Resource resource) throws DingException {

        try {
            return upload(mediaType, new FileItem(resource.getFilename(), resource.getInputStream()));
        } catch (IOException e) {
            throw new DingException(e.getMessage(), e);
        }
    }

    private DingMediaResponse upload(MediaType mediaType, FileItem fileItem) {
        OapiMediaUploadRequest request = new OapiMediaUploadRequest();
        request.setType(mediaType.getType());
        request.setMedia(fileItem);
        OapiMediaUploadResponse response = execute("/media/upload", request);
        LocalDateTime createdAt =
                LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(ObjectUtil.defaultIfNull(response.getCreatedAt(), System.currentTimeMillis())),
                        ZoneId.systemDefault());
        return DingMediaResponse.builder()
                .createdAt(createdAt)
                .mediaId(response.getMediaId())
                .type(mediaType)
                .build();
    }

    @Override
    public DingMediaResponse upload(MediaType mediaType, String fileName, InputStream inputStream) throws DingException {
        return upload(mediaType, new FileItem(fileName, inputStream));

    }

    @Override
    public DingMediaResponse upload(MediaType mediaType, File file) throws DingException {
        return upload(mediaType, new FileItem(file));
    }

    @Override
    public DingMediaResponse upload(MediaType mediaType, String fileName, byte[] content) throws DingException {
        return upload(mediaType, new FileItem(fileName, content));
    }
}
