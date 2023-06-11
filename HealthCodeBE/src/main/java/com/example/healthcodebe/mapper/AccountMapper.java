package com.example.healthcodebe.mapper;

import com.example.healthcodebe.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.healthcodebe.entity.HealthCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyc
 * @since 2023-05-21 23:28:35
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    Account getAccountInfo(@Param("condition") Map<String, Object> condition);

    Account getAccountById(String id);
    void add(Account account);

    boolean updatePasswd(@Param("condition") Map<String, Object> condition);

    boolean updatePhoneNumber(@Param("condition") Map<String, Object> condition);

    boolean updateAdmin(@Param("condition") Map<String, Object> condition);

    boolean updateTester(@Param("condition") Map<String, Object> condition);

    boolean updateSampler(@Param("condition") Map<String, Object> condition);
}
