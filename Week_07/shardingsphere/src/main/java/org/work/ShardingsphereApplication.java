package org.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Leeyj
 * @date 2021/3/12 20:49
 */
@SpringBootApplication
@MapperScan(value = "org.work.week07.dao")
@ComponentScan(basePackages = {"org.work.week07"})
public class ShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereApplication.class,args);
    }

}
