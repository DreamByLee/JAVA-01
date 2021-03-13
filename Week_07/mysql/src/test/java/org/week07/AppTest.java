package org.week07;

import static org.junit.Assert.assertTrue;

import javafx.scene.control.Tab;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.week07.sourceV1.annotation.DataSource;
import org.week07.sourceV1.entity.TableBean;
import org.week07.sourceV1.service.TableService;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DynamicDatasourceApplication.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Autowired
    private TableService tableService;

    @Test
    @DataSource(value = "master")
    public void testMaster() {
        TableBean tableBean = new TableBean();
        Integer result = tableService.addInfo(tableBean);
        System.out.println("Master insert id=>"+result);
    }

    @Test
    @DataSource(value = "slave")
    public void testSlave() {
        List<TableBean> tableBean = tableService.findAll();
        System.out.println("Slave=>"+tableBean);
    }

    @Test
    public void testShardingshere() {
        TableBean tableBean = new TableBean();
        Integer result = tableService.addInfo(tableBean);
        List<TableBean> tableBeans = tableService.findAll();

    }
}
