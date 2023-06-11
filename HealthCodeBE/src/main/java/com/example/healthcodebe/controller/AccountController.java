package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.utils.PassToken;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-21 23:28:35
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/getAllAccounts.json")
    public @ResponseBody Object GetAllUsers(){
        return accountService.getAllAccounts();
    }

    @RequestMapping("/login")
    @PassToken
    public Account login (@RequestParam Map<String, Object> condition) {
        Map<String, Object> map = new HashMap<>();
        map.put("id_number", condition.get("user_id").toString());
        map.put("password", condition.get("passwd").toString());
        Account account = accountService.getAccountInfo(map);
        String token = accountService.getToken(account, 24*60* 60 * 1000);
        String refreshToken = accountService.getToken(account, 24*60*60*1000); // 有效期一天
        account.setToken(token);
        account.setRefreshToken(refreshToken);
        return account;
    }

    @RequestMapping("/register")
    public boolean register (@RequestParam Map<String, Object> condition) {
        Account account = new Account();
        account.setIdNumber(condition.get("user_id").toString());
        account.setPassword(condition.get("passwd").toString());
        account.setPhoneNumber(condition.get("phone").toString());
        account.setAdmin(Boolean.FALSE);
        account.setSampler(Boolean.FALSE);
        account.setTester(Boolean.FALSE);
        if (accountService.getAccountById(account.getIdNumber()) != null) return false;
        accountService.addAccount(account);
        return accountService.getAccountById(account.getIdNumber()) != null;
    }

    @RequestMapping("/edit_passwd")
    public boolean updatePasswd(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Map<String, Object> map = new HashMap<>();
        map.put("id_number", id_number);
        map.put("password", condition.get("passwd").toString());
        return accountService.updatePasswd(map);
    }

    @RequestMapping("/edit_phone")
    public boolean updatePhone (@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Map<String, Object> map = new HashMap<>();
        map.put("id_number", id_number);
        map.put("phone_number", condition.get("phone").toString());
        return accountService.updatePhoneNumber(map);
    }

    @RequestMapping("/identify_info")
    public Account getInfo (@RequestHeader("Authorization") String token) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        return account;
    }

    @RequestMapping("/authorize_admin")
    public boolean authorizeAdmin (@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if (!account.getAdmin()) {
            return false;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id_number", condition.get("user_id").toString());
        map.put("admin", 1);
        return accountService.updateAdmin(map);
    }

    @RequestMapping("/authorize_tester")
    public boolean authorizeTester (@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if (!account.getAdmin()) {
            return false;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id_number", condition.get("user_id").toString());
        map.put("tester", 1);
        return accountService.updateTester(map);
    }

    @RequestMapping("/authorize_sampler")
    public boolean authorizeSampler (@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if (!account.getAdmin()) {
            return false;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id_number", condition.get("user_id").toString());
        map.put("sampler", 1);
        return accountService.updateSampler(map);
    }
}
