package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.TestPosition;
import com.example.healthcodebe.entity.TestPositionInfo;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.TestPositionService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:46:50
 */
@RestController
@RequestMapping("/test-position")
public class TestPositionController {
    @Autowired
    private TestPositionService testPositionService;
    @Autowired
    private AccountService accountService;
    @RequestMapping("/user/rna_detect_position")
    public List<TestPositionInfo> user_rna_detect_position(@RequestParam Map<String, Object> condition){
        Map<String, Object> map = new HashMap<>();
        // 为了方便调用这个接口的同学不用翻到xml层看格式
        map.put("longitude_low", Double.valueOf(condition.get("longitude_low").toString()));
        map.put("longitude_high", Double.valueOf(condition.get("longitude_high").toString()));
        map.put("latitude_low", Double.valueOf(condition.get("latitude_low").toString()));
        map.put("latitude_high", Double.valueOf(condition.get("latitude_high").toString()));
        return testPositionService.getTestPositionByCoordinate(map);
    }

    @RequestMapping("/user/rna_detect_info")
    public TestPositionInfo user_rna_detect_position_info(@RequestParam Map<String, Object> condition){
        // 为了方便调用这个接口的同学不用翻到xml层看格式

        return testPositionService.getTestPositionById(condition.get("place_id").toString());
    }

    @RequestMapping("/admin/detect_site_create")
    public boolean admin_detect_site_create(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        TestPosition testPosition = new TestPosition();
        testPosition.setEndTime(LocalTime.parse(condition.get("end_time").toString()));
        testPosition.setStartTime(LocalTime.parse(condition.get("start_time").toString()));
        testPosition.setPlaceId(Integer.valueOf(condition.get("place_id").toString()));
        testPosition.setManagerIdNumber(condition.get("maneger_id").toString());
        testPositionService.addTestPosition(testPosition);
        return true;
    }

    @RequestMapping("/admin/detect_info_change")
    public boolean admin_detect_info_change(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        TestPositionInfo testPositionInfo = testPositionService.getTestPositionById(condition.get("place_id").toString());
        if(testPositionInfo == null){
            // 这个项不存在，不能update
            return false;
        }
        TestPosition testPosition = new TestPosition();
        testPosition.setEndTime(LocalTime.parse(condition.get("end_time").toString()));
        testPosition.setStartTime(LocalTime.parse(condition.get("start_time").toString()));
        testPosition.setPlaceId(Integer.valueOf(condition.get("place_id").toString()));
        testPosition.setManagerIdNumber(condition.get("maneger_id").toString());
        testPositionService.updateTestPosition(testPosition);
        return true;
    }

    @RequestMapping("/admin/detect_site_list")
    public @ResponseBody Object admin_detect_site_list(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("page_size", Integer.valueOf(condition.get("page_size").toString()));
        Integer offset = Integer.valueOf(condition.get("page_size").toString()) * (Integer.valueOf(condition.get("page").toString()) - 1);
        map.put("offset", offset);

        return testPositionService.getTestPositionByPage(map);
    }
}
