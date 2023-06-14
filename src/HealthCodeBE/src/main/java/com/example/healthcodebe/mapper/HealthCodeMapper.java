package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.HealthCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:55
 */
@Mapper
public interface HealthCodeMapper extends BaseMapper<HealthCode> {
    HealthCode getHealthCodeById(String id);
    void initHealthCodeWhenRegister(HealthCode healthCode);

    void healthCodeChangeById(@Param("condition") Map<String, Object> condition);
}
