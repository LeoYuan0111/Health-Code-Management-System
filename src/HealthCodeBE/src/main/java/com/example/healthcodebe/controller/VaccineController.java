package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.Vaccine;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:24
 */
@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @Autowired
    AccountService accountService;

    @RequestMapping("/admin/addVaccine")
    public boolean addVaccine(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if (!account.getAdmin()) {
            return false;
        }
        Vaccine vaccine = new Vaccine();
        vaccine.setDate(LocalDateTime.now());
        vaccine.setProvider(condition.get("provider").toString());
        vaccine.setVaccId(0);
        vaccine.setExpirationDate(LocalDateTime.of(2024, 12, 31, 23, 59));
        vaccineService.addVaccine(vaccine);
        return true;
    }
}
