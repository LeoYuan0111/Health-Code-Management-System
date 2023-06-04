package com.example.healthcodebe.utils;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.healthcodebe.service.AccountService;
import com.example.healthcodebe.entity.Account;
import com.example.healthcodebe.service.impl.UploadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Description 拦截器去获取token并验证token
 **/
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final Log logger = LogFactory.getLog(UploadServiceImpl.class);

    @Autowired
    AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        //通过所有OPTION请求
        if(httpServletRequest.getMethod().toUpperCase().equals("OPTIONS")){
            return true;
        }

        String token = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token
        String refreshToken = httpServletRequest.getHeader("freshToken");// 从 http 请求头中取出 token
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        //2.遍历
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //通过请求头的名称获取请求头的值
            String value = httpServletRequest.getHeader(name);
            System.out.println(name+"----"+value);
        }
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        // 获取 token 中的 用户信息
        String userValue = null;
        try {
            userValue = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        Account user = accountService.getAccountById(userValue);
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }


        Date oldTime = JWT.decode(token).getExpiresAt();
        Date refreshTime = JWT.decode(refreshToken).getExpiresAt();
        long oldDiff = oldTime.getTime() - new Date().getTime();//这样得到的差值是毫秒级别
        long refreshDiff = refreshTime.getTime() - new Date().getTime();//这样得到的差值是毫秒级别
        if (oldDiff <= 0) {
            if (refreshDiff <= 0) {
                logger.error("=== token 已过期, 请重新登录 ===");
                httpServletResponse.sendError(401);
                return false;
//        throw new RuntimeException("401");
            }
        }
        String newToken = accountService.getToken(user, 60* 60 * 1000);
        String newRefToken = accountService.getToken(user, 24*60*60*1000);
        // 更新token
        httpServletResponse.setHeader("Authorization", newToken);
        httpServletResponse.setHeader("freshToken", newRefToken);

        //检查有没有需要用户权限的注解
//    if (method.isAnnotationPresent(UserLoginToken.class)) {  // 是否使用@UserLoginToken注解
//      UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//      if (userLoginToken.required()) {
        // 执行认证
        if (token == null) {
            throw new RuntimeException("=== 无token，请重新登录 ===");
        }
        // 利用用户密码，解密验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            logger.error("=== token验证失败 ===");
            httpServletResponse.sendError(401);
            return false;
//          throw new RuntimeException("401");
        }
//        return true;
//      }
//    }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
