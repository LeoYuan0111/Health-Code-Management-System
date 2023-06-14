package com.example.healthcodebe.config;

import com.example.healthcodebe.utils.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description 解决vue+spring boot跨域问题
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS")
                .maxAge(3600 * 24);
    }
    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/account/login");  //登录
        excludePath.add("/account/register");
        excludePath.add("/test/**");
//        excludePath.add("/api/place/getPlace/**");

        registry.addInterceptor(appInterceptor())
                .addPathPatterns("/**")//添加拦截路径,拦截所有
                .excludePathPatterns(excludePath); // 排除的拦截路径

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public HandlerInterceptor appInterceptor(){
        return new AuthenticationInterceptor();
    }
}
