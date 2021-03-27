package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class TransactionConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionConsumerApplication.class, args);
    }

}
