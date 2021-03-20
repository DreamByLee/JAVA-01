package com.lee.topic01;

import com.lee.topic01.entity.IndentInfo;
import com.lee.topic01.service.IndentInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.IntStream;

@SpringBootTest(classes = Topic01Application.class)
class Topic01ApplicationTests {

    @Autowired
    private IndentInfoService indentInfoService;

    @Test
    public void testAdd() {

        for (int i = 0; i < 500; i++) {
            IndentInfo indentInfo = new IndentInfo();
            indentInfo.setCustomerId(i);
            indentInfo.setIndentPrice(0.01 + i);
            indentInfo.setPayTime(new Date());
            indentInfo.setPayType(i+"");
            indentInfoService.saveIndent(indentInfo);
        }
    }

    /**
     * 用户ID和订单ID 可任选其一或多选，两个ID都传时sql语句命中越精确
     */
    @Test
    public void testDel() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfo.setCustomerId(18);
        indentInfo.setIndentId(1372177663207809025L);
        indentInfoService.rmIndent(indentInfo);
    }

    @Test
    public void testUpdate() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfo.setIndentPrice(99.98);
        indentInfo.setIndentId(1372177665690836993L);
        indentInfoService.upIndent(indentInfo);
    }

    @Test
    public void testSelect() {
        IndentInfo indentInfo = new IndentInfo();
        indentInfo.setIndentId(1372177663140700161L);
        indentInfo.setCustomerId(15);
        List<IndentInfo> indentInfos = indentInfoService.queryIndent(indentInfo);
        System.out.println(indentInfos);
    }

    /**
     * XA事务，成功提交
     */
    @Test
    public void testSuccesCommit() {
        List<IndentInfo> indentInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IndentInfo indentInfo = new IndentInfo();
            indentInfo.setCustomerId(i);
            indentInfo.setIndentPrice(0.01 + i);
            indentInfo.setPayTime(new Date());
            indentInfo.setPayType(i+"");
            indentInfos.add(indentInfo);
        }
        indentInfoService.saveIndentXA(indentInfos);
    }

    /**
     * XA事务，模拟失败回滚
     */
    @Test
    public void testFailCommit() {
        List<IndentInfo> indentInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IndentInfo indentInfo = new IndentInfo();
            indentInfo.setCustomerId(i);
            indentInfo.setIndentPrice(0.01 + i);
            indentInfo.setPayTime(new Date());
            indentInfo.setPayType(i+"");
            indentInfos.add(indentInfo);
        }
        //设置字段非对应数据库字段类型
        indentInfos.get(0).setPayType("测试失败类型");
        indentInfoService.saveIndentXA(indentInfos);
    }

}
