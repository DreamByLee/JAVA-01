package com.lee.topic01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lee.topic01.mapper")
public class Topic01Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic01Application.class, args);
    }

}
