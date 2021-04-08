package com.example.demo;

import com.example.demo.entity.IndentInfo;
import com.example.demo.service.IndentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoApplicationTests {
    @Autowired
    private IndentService indentService;

    @Test
    public void testIndent() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfo.setCustomerId(001);
        indentInfo.setIndentPrice(0.5);
        indentInfo.setPayTime(new Date());
        indentInfo.setPayType("1");
        indentService.readyCreateIndent(indentInfo);
    }

}
