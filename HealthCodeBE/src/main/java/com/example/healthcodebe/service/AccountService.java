package com.example.healthcodebe.service;

import com.example.healthcodebe.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

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

    Account getAccountById(String id);

    Account getAccountInfo(Map<String, Object> condition);

    String getToken(Account user, long time);

    void addAccount(Account account);

    boolean updatePasswd(Map<String, Object> map);

    boolean updatePhoneNumber(Map<String, Object> map);

    boolean updateAdmin(Map<String, Object> condition);

    boolean updateTester(Map<String, Object> map);

    boolean updateSampler(Map<String, Object> map);
}
