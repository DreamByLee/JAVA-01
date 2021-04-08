package com.example.demo.config;

import com.example.demo.subscribe.IndentSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@Slf4j
public class MessageConfig {
    @Autowired
    private IndentSubscriber indentSubscriber;

    /**
     * 订阅消息
     * @return
     */
    @Bean
    MessageListenerAdapter listenerAdapter() {
        return new MessageListenerAdapter(indentSubscriber);
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter)
    {
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //指定订阅通道
        container.addMessageListener(listenerAdapter,new PatternTopic("*Indent"));

        return container;
    }

}
