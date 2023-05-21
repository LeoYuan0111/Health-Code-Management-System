package com.example.healthcodebe.controller;

import com.example.healthcodebe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
