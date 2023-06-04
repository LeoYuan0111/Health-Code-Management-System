package com.example.healthcodebe.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.example.healthcodebe.mapper.UploadMapper;
import com.example.healthcodebe.service.UploadService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Description 上传业务层
 **/
@Service
public class UploadServiceImpl implements UploadService {

    private final Log logger = LogFactory.getLog(UploadServiceImpl.class);

    @Resource
    private UploadMapper uploadMapper;

    @Override
    public String getHead(Map<String, Object> condition) {
        return null;
    }
}
