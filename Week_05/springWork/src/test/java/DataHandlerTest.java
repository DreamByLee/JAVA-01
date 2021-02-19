import io.work03.JdbcDao;
import io.work03.DataDemoApplication;
import io.work03.PreparedStatementDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * @author Leeyj
 * @date 2021/2/19 13:33
 * 多种数据处理测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataDemoApplication.class)
//@WebAppConfiguration
public class DataHandlerTest {

    @Autowired
    private JdbcDao jdbcDao;
    @Autowired
    private PreparedStatementDao psDao;

    /**
     * jdbc
     */
    @Test
    public void testJdbc() {
        jdbcDao.insertStudent();
        jdbcDao.updateStudent();
        jdbcDao.removeStudent();

        //批处理
        jdbcDao.batchInsert();

        jdbcDao.queryStudent();
    }

    /**
     * PrepareStatement
     * @throws SQLException
     */
    @Test
    public void testPrepareStatement() throws SQLException {
        psDao.getConn();
        psDao.insertStudent();
        psDao.updateStudent();
        psDao.removeStudent();
        psDao.queryStudent();
        psDao.closeConn();
    }

}
