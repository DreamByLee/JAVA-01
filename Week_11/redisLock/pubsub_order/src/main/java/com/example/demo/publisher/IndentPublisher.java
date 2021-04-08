package com.example.demo.publisher;

import com.example.demo.entity.IndentInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IndentPublisher {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 发送订单消息
     */
    public void sendIndent(IndentInfo indentInfo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(indentInfo);
            redisTemplate.convertAndSend("createIndent", s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
