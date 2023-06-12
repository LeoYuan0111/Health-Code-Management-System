package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.VaccinationInfo;
import com.example.healthcodebe.entity.VaccinationRecord;
import com.example.healthcodebe.entity.Vaccine;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.VaccinationRecordService;
import com.example.healthcodebe.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:36:49
 */
@RestController
@RequestMapping("/vaccination-record")
public class VaccinationRecordController {
    @Autowired
    VaccineService vaccineService;

    @Autowired
    AccountService accountService;

    @Autowired
    VaccinationRecordService vaccinationRecordService;

    @RequestMapping("/user/vaccine_plant_info")
    public List<VaccinationInfo> vaccine_plant_info(@RequestHeader("Authorization") String token){
        String id_number = JWT.decode(token).getAudience().get(0);
        return vaccinationRecordService.getVaccinationInfoById(id_number);
    }

    @RequestMapping("/admin/vaccine_plant_info")
    public @ResponseBody Object admin_vaccine_plant_info(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        String target_id = condition.get("id_number").toString();
        return vaccinationRecordService.getVaccinationInfoById(target_id);
    }
    @RequestMapping("/sampler/add_vaccine_info")
    public boolean add_vaccine_info(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getSampler() == false){
            return false;
        }
        VaccinationRecord vaccinationRecord = new VaccinationRecord();
        vaccinationRecord.setInjectDate(LocalDateTime.now());
        vaccinationRecord.setIdNumber(condition.get("id_number").toString());
        vaccinationRecord.setDocIdNumber(id_number);
        vaccinationRecord.setVaccId(Integer.valueOf(condition.get("vacc_id").toString()));
        vaccinationRecordService.addVaccinationInfo(vaccinationRecord);
        return true;
    }
}
