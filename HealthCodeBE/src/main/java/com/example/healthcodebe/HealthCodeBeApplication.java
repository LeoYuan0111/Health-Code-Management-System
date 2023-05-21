package com.example.healthcodebe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan("com.example")
public class HealthCodeBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCodeBeApplication.class, args);
    }

}
