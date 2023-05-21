package com.example.healthcodebe.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.mapper.AccountMapper;
import com.example.healthcodebe.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Account> getAllAccounts() {
        return accountMapper.selectList(null);
    }

    @Override
    public int createAccount(Account account) {
        return accountMapper.insert(account);
    }
}
