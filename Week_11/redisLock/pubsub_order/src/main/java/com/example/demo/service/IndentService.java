package com.example.demo.service;

import com.example.demo.entity.IndentInfo;
import com.example.demo.publisher.IndentPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndentService {
    @Autowired
    private IndentPublisher indentPublisher;

    /**
     * 准备发送订单消息
     * @param indentInfo
     */
    public void readyCreateIndent(IndentInfo indentInfo) {
        indentPublisher.sendIndent(indentInfo);
        log.info("准备创建订单，send.....");
    }

    public void confirmCreateIndent(IndentInfo indentInfo) {
        log.info("订单创建中...,indentInfo={}",indentInfo);
        log.info("创建订单成功...");
    }
}
