package com.example.healthcodebe.service;

import java.util.Map;

/**
 * Description 上传文件service层
 **/
public interface UploadService {
    /**
     * description: 上传头像
     * @param: upload
     * return: void
     */
//    void uploadHead(Upload upload);
    /**
     * description: 获取头像
     * @param: condition
     * return: String
     */
    String getHead(Map<String, Object> condition);
}
