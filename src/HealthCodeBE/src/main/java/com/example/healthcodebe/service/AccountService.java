package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyc
 * @since 2023-05-21 23:28:35
 */
public interface AccountService extends IService<Account> {
    List<Account> getAllAccounts();

    int createAccount(Account account);
}
