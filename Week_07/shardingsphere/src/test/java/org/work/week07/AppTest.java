package org.work.week07;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.work.ShardingsphereApplication;
import org.work.week07.entity.TableBean;
import org.work.week07.service.TableService;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingsphereApplication.class)
public class AppTest {
    @Autowired
    private TableService tableService;

    @Test
    public void testShardingshereAdd() {
        TableBean tableBean = new TableBean();
        tableService.addInfo(tableBean);
    }

    @Test
    public void testShardingshereQuery() {
        List<TableBean> tableBeans = tableService.findAll();
//        System.out.println(tableBeans);
    }

}
