package com.example.healthcodebe.controller;

import com.auth0.jwt.JWT;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.entity.PlaceCode;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.service.PlaceCodeService;
import com.example.healthcodebe.utils.QRCodeUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyc
 * @since 2023-05-22 00:40:22
 */
@RestController
@RequestMapping("/place-code")
public class PlaceCodeController {
    @Autowired
    private PlaceCodeService placeCodeService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/user/site_register")
    public void site_register(@RequestHeader("Authorization") String token, HttpServletResponse response, @RequestParam Map<String, Object> condition){
        String id_number = JWT.decode(token).getAudience().get(0);
        Account account = accountService.getAccountById(id_number);

        PlaceCode placeCode = new PlaceCode();
        placeCode.setPlaceId(0);
        placeCode.setCity(condition.get("city").toString());
        placeCode.setCounty(condition.get("county").toString());
        placeCode.setProvince(condition.get("province").toString());
        placeCode.setVillage(condition.get("village").toString());
        placeCode.setDetailAddr(condition.get("detail_addr").toString());
        placeCode.setPhoneNumber(account.getPhoneNumber());
        placeCode.setLatitude(Double.valueOf(condition.get("latitude").toString()));
        placeCode.setLongitude(Double.valueOf(condition.get("longitude").toString()));

        placeCodeService.addPlaceCode(placeCode);
        PlaceCode placeCode_new_get = placeCodeService.getNewPlaceCode(condition);

        String content = "place_id = " + placeCode_new_get.getPlaceId().toString();
        BufferedImage image;
        // 禁止图像缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        image = QRCodeUtil.createImage(content, "Black");
        // 创建二进制的输出流
        try(ServletOutputStream sos = response.getOutputStream()){
            // 将图像输出到Servlet输出流中。
            ImageIO.write(image, "jpeg", sos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
