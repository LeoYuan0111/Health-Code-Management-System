package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.HealthCode;
import com.example.healthcodebe.mapper.AccountMapper;
import com.example.healthcodebe.mapper.HealthCodeMapper;
import com.example.healthcodebe.service.HealthCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import net.bytebuddy.asm.Advice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:55
 */
@Service
public class HealthCodeServiceImpl extends ServiceImpl<HealthCodeMapper, HealthCode> implements HealthCodeService {
    @Resource
    private HealthCodeMapper healthCodeMapper;
    @Override
    public HealthCode getHealthCodeById(String id){
        return healthCodeMapper.getHealthCodeById(id);
    }
    @Override
    public void healthCodeChangeById(@Param("condition") Map<String, Object> condition){
        Map<String, Object> condition_new = new HashMap<>();
        condition_new.put("update_time", LocalDateTime.now());
        condition_new.put("color", condition.get("tocolor").toString());
        condition_new.put("id_number", condition.get("id_number").toString());
        healthCodeMapper.healthCodeChangeById(condition_new);
        return;
    }
}
