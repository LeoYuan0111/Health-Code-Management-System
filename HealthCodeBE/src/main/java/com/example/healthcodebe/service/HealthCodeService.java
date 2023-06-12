package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.HealthCode;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:55
 */
public interface HealthCodeService extends IService<HealthCode> {
    HealthCode getHealthCodeById(String id);
    void healthCodeChangeById(@Param("condition") Map<String, Object> condition);
}
