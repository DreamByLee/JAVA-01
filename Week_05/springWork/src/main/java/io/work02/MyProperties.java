package io.work02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leeyj
 * @date 2021/2/18 13:46
 */
@Configuration
public class MyProperties {

    @Bean
    School getSchool() {
        return new School();
    }

    @Bean(initMethod = "init",destroyMethod = "print")
//    @Bean
    Student student100() {
        return new Student(100,"DreamByLee");
    }

    @Bean
    Klass getClazz() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "DreamByLee" + i));
        }
        System.out.println(students.toString());
        return new Klass(students);
    }
}
