package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.PlaceVisit;
import com.example.healthcodebe.entity.PlaceVisitInfo;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.PlaceVisitService;
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
 * @since 2023-05-22 00:40:52
 */
@RestController
@RequestMapping("/place-visit")
public class PlaceVisitController {
    @Autowired
    private PlaceVisitService placeVisitService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/user/site_scan")
//    普通用户扫场所码
    public boolean user_site_scan(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        PlaceVisit placeVisit = new PlaceVisit();
        placeVisit.setPlaceId(Integer.valueOf(condition.get("place_id").toString()));
        placeVisit.setVisitTime(LocalDateTime.now());
        placeVisit.setIdNumber(id_number);
        placeVisitService.addPlaceVisit(placeVisit);
        return true;
    }

    @RequestMapping("/user/trace_code_info")
//    普通用户查询自己场所码轨迹
    public List<PlaceVisitInfo> user_trace_code_info(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        return placeVisitService.getPlaceVisitInfoById(id_number);
    }

    @RequestMapping("/admin/trace_code_info")
//    admin查询普通用户的场所码轨迹
    public @ResponseBody Object admin_trace_code_info(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        String target_id = condition.get("id_number").toString();
        return placeVisitService.getPlaceVisitInfoById(target_id);
    }
}
