package com.example.healthcodebe.service.impl;

import com.example.healthcodebe.entity.HealthCode;
import com.example.healthcodebe.mapper.AccountMapper;
import com.example.healthcodebe.mapper.HealthCodeMapper;
import com.example.healthcodebe.service.HealthCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
}
