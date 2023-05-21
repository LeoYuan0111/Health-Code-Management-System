package com.example.healthcodebe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@MapperScan("com.example.healthcodebe.mapper")
public class HealthCodeBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCodeBeApplication.class, args);
    }

}
