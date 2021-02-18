package io.work01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leeyj
 * @date 2021/2/17 10:18
 */
@Configuration
public class OpenLoadConfig {

    @Bean
    public Cat helloCat() {
        return new Cat();
    }

    @Bean
    public Dog helloDog() {
        return new Dog();
    }
}
