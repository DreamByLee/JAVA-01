package com.lee.topic01;

import com.lee.topic01.entity.IndentInfo;
import com.lee.topic01.service.IndentInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = Topic01Application.class)
class Topic01ApplicationTests {

    @Autowired
    private IndentInfoService indentInfoService;

    @Test
    public void testAdd() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfo.setCustomerId(12);
        indentInfo.setIndentPrice(0.01 + 12);
        indentInfo.setPayTime(new Date());
        indentInfo.setPayType(1);
        indentInfoService.saveIndent(indentInfo);
        /*for (int i = 0; i < 32; i++) {
            indentInfo.setCustomerId(i);
            indentInfo.setIndentPrice(0.01 + i);
            indentInfo.setPayTime(new Date());
            indentInfo.setPayType(i);
            indentInfoService.saveIndent(indentInfo);
        }*/
    }

    @Test
    public void testDel() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfoService.rmIndent(1234343);
    }

    @Test
    public void testUpdate() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfo.setIndentPrice(99.98);
        indentInfo.setIndentId(1L);
        indentInfoService.upIndent(indentInfo);
    }

    @Test
    public void testSelect() {
        List<IndentInfo> indentInfos = indentInfoService.queryIndent();
    }

}
