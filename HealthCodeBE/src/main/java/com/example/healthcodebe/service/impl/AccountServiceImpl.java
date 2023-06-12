package com.example.healthcodebe.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.HealthCode;
import com.example.healthcodebe.mapper.AccountMapper;
import com.example.healthcodebe.mapper.HealthCodeMapper;
import com.example.healthcodebe.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

//import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyc
 * @since 2023-05-21 23:28:35
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private HealthCodeMapper healthCodeMapper;

    @Override
    public List<Account> getAllAccounts() {
        return accountMapper.selectList(null);
    }

    @Override
    public Account getAccountById(String id) {
        Account account = new Account();
        account = accountMapper.getAccountById(id);
        return account;
    }

    @Override
    public Account getAccountInfo(Map<String, Object> condition) {
        return accountMapper.getAccountInfo(condition);
    }

    @Override
    public int createAccount(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public String getToken(Account account, long time) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + time;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        token = JWT.create().withAudience(account.getIdNumber()).withIssuedAt(start).withExpiresAt(end)
                // 储存id和level
                .sign(Algorithm.HMAC256(account.getPassword())); // 储存password，用于解密
        return token;
    }

    @Override
    public void addAccount(Account account) {
        accountMapper.add(account);
        HealthCode healthCode = new HealthCode();
        healthCode.setColor(2);
        healthCode.setQrCode("".toString());
        healthCode.setUpdateTime(LocalDateTime.now());
        healthCode.setIdNumber(account.getIdNumber());
        healthCodeMapper.initHealthCodeWhenRegister(healthCode);
    }

    @Override
    public boolean updatePasswd(Map<String, Object> map) {
        return accountMapper.updatePasswd(map);
    }

    @Override
    public boolean updatePhoneNumber(Map<String, Object> map) {
        return accountMapper.updatePhoneNumber(map);
    }

    @Override
    public boolean updateAdmin(Map<String, Object> condition) {
        return accountMapper.updateAdmin(condition);
    }

    @Override
    public boolean updateTester(Map<String, Object> map) {
        return accountMapper.updateTester(map);
    }

    @Override
    public boolean updateSampler(Map<String, Object> map) {
        return accountMapper.updateSampler(map);
    }

    @Override
    public List<Account> getAuthorityInfo(){
        Map<String, Object> condition = new HashMap<>();
        condition.put("nothing", "");
        return accountMapper.getAuthorityInfo(condition);
    }
}
