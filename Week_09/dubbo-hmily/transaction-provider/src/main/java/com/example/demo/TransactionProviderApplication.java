package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@MapperScan(basePackages = "com.example.demo.mapper")
public class TransactionProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionProviderApplication.class, args);
    }

}
