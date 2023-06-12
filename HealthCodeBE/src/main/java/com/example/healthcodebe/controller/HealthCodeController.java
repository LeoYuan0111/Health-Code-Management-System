package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.Complain;
import com.example.healthcodebe.entity.HealthCode;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.HealthCodeService;
import com.example.healthcodebe.service.ComplainService;
import com.example.healthcodebe.utils.QRCodeUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:39:55
 */
@RestController
@RequestMapping("/health-code")
public class HealthCodeController {
    @Autowired
    private HealthCodeService healthCodeService;
    @Autowired
    private ComplainService complainService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/user/health_code")
    public void health_code(@RequestHeader("Authorization") String token, HttpServletResponse response) {
        String id_number = JWT.decode(token).getAudience().get(0);
        HealthCode healthCode = new HealthCode();
        healthCode = healthCodeService.getHealthCodeById(id_number);
        String color = "Green".toString();
        if (healthCode != null) {
            if (healthCode.getColor() == 1) {
                // Yellow
                color = "Yellow".toString();
            } else if (healthCode.getColor() == 0) {
                // Green
                color = "Red".toString();
            }
        } else {
            color = "Black".toString();
        }

        String content = id_number + "#".toString() +  LocalDateTime.now().toString();
        BufferedImage image;
        // 禁止图像缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        image = QRCodeUtil.createImage(content, color);
//        System.out.print(color);
        // 创建二进制的输出流
        try(ServletOutputStream sos = response.getOutputStream()){
            // 将图像输出到Servlet输出流中。
            ImageIO.write(image, "jpeg", sos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/user/health_code_appeal")
    public boolean health_code_appeal(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Complain complain = new Complain();
        complain.setTime(LocalDateTime.now());
        complain.setContent(condition.get("content").toString());
        complain.setIdNumber(id_number);
        complain.setComplainId("".toString());
        complain.setResult(0);
        // 0 - 未审核 1 - 通过 2 - 不通过
        complain.setReply("".toString());
        complain.setWithdraw(0);
        // 0 - 未撤销 1 - 已撤销
        return complainService.addComplain(complain);
    }

    @RequestMapping("/user/show_all_appeal")
    public @ResponseBody Object getComplain(@RequestHeader("Authorization") String token){
        String id_number = JWT.decode(token).getAudience().get(0);
        return complainService.getComplainById(id_number);
    }

    @RequestMapping("/user/health_appeal_revoke")
    public boolean health_code_appeal(@RequestParam Map<String, Object> condition){
        String complain_id = condition.get("complain_id").toString();
        if (complainService.getComplainByComplainId(complain_id) == null){
            return false;
        }
        complainService.withDraw(complain_id);
        return true;
    }

    @RequestMapping("/admin/complain_info")
    public @ResponseBody Object complain_info(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return null;
        }
        String complain_id = condition.get("complain_id").toString();
        return complainService.getComplainByComplainId(complain_id);
    }

    @RequestMapping("/admin/complain_list")
    public @ResponseBody Object complain_list(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return null;
        }
        return complainService.getComplainListByPage(condition);
    }

    @RequestMapping("/admin/deal_complain")
    public boolean deal_complain(@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);
        if(account.getAdmin() == false){
            return false;
        }
        complainService.dealComplain(condition);
        return true;
    }



}
