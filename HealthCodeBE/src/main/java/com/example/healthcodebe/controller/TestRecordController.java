package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.*;
import com.example.healthcodebe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:37:31
 */
@RestController
@RequestMapping("/")
public class TestRecordController {
    @Autowired
    private TestRecordService testRecordService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PlaceVisitService placeVisitService;

    @Autowired
    private HealthCodeService healthCodeService;

    @Autowired
    private ColorChangeService colorChangeService;

    @RequestMapping("/sampled_info")
    public boolean sampleInfo (@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if (!account.getSampler()) {
            return false;
        }
        TestRecord testRecord = new TestRecord();
        testRecord.setIdNumber(condition.get("user_id").toString());
        testRecord.setTubeId(Integer.decode(condition.get("tube_id").toString()));
        testRecord.setDate(LocalDateTime.now());
        testRecord.setResult(0);
        // 0 - 未出 1 - 阴 2 - 阳
        testRecord.setSamplerIdNumber(id_number);
        testRecord.setTesterIdNumber("unknown");
        return testRecordService.addSampleInfo(testRecord);
    }

    @RequestMapping("/detect_result")
    public boolean updateDetectResult (@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition) {
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if (!account.getTester()) {
            return false;
        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("tube_id", Integer.decode(condition.get("tube_id").toString()));
//        map.put("date", LocalDateTime.now());
//        map.put("result", Integer.decode(condition.get("rna_result").toString()));
//        map.put("tester_id_number", id_number);
        // 录入结果
        TestRecord testRecord = testRecordService.getByTubeId(condition.get("tube_id").toString());
        testRecord.setDate(LocalDateTime.now());
        testRecord.setResult(Integer.decode(condition.get("rna_result").toString()));
        testRecord.setTesterIdNumber(id_number);
        // 改码的颜色

        boolean flag = testRecordService.updateDetectResult(testRecord);

        if(flag == true){
            String target_id = testRecord.getIdNumber().toString();
            if(testRecord.getResult() == 2){
                // 阳了，需要将密接转黄
                List<Id> CloseIdNumbers = placeVisitService.getCloseContactById(target_id);
                for(Id _id : CloseIdNumbers){
                    String id = _id.getIdNumber();
                    Map<String, Object> map = new HashMap<>();
                    map.put("id_number", id);
                    map.put("tocolor", 1);
                    HealthCode healthCode = healthCodeService.getHealthCodeById(id);
                    if(healthCode.getColor() > 1) {
                        // 绿转黄
                        healthCodeService.healthCodeChangeById(map);

                        ColorChange colorChange = new ColorChange();
                        colorChange.setReason("Close contact with Positive, 阳性密接");
                        colorChange.setTocolor(1);
                        colorChange.setTime(LocalDateTime.now());
                        colorChange.setIdNumber(id);
                        colorChangeService.addColorChange(colorChange);
                    }
                }
                // 将本人变红
                Map<String, Object> map = new HashMap<>();
                map.put("id_number", target_id);
                map.put("tocolor", 0);
                healthCodeService.healthCodeChangeById(map);

                ColorChange colorChange = new ColorChange();
                colorChange.setReason("Postive, 阳了");
                colorChange.setTocolor(0);
                colorChange.setTime(LocalDateTime.now());
                colorChange.setIdNumber(target_id);
                colorChangeService.addColorChange(colorChange);
            } else if (testRecord.getResult() == 1) {
                // 阴了，转绿
                Map<String, Object> map = new HashMap<>();
                map.put("id_number", target_id);
                map.put("tocolor", 2);
                healthCodeService.healthCodeChangeById(map);

                ColorChange colorChange = new ColorChange();
                colorChange.setReason("Negative, 阴了");
                colorChange.setTocolor(2);
                colorChange.setTime(LocalDateTime.now());
                colorChange.setIdNumber(target_id);
                colorChangeService.addColorChange(colorChange);
            }

        }
        return flag;
    }

    @RequestMapping("/rna_detect_result")
    public List<TestRecord> getDetectResults (@RequestHeader("Authorization") String token) {
        String id_number = JWT.decode(token).getAudience().get(0);
        return testRecordService.getDetectResults(id_number);
    }
    @RequestMapping("/admin/rna_detect_result")
    public @ResponseBody Object admin_rna_detect_result(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        String target_id = condition.get("id_number").toString();
        return testRecordService.getDetectResults(target_id);
    }
}
