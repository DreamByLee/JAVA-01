import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.*;

/**
 * @author Leeyj
 * @date 2021/3/2 11:28
 */
public class BatchInsertIndentTest {



    private String url = "jdbc:mysql://localhost:3306/week06?rewriteBatchedStatements=true";
    private String user ="root";
    private String password ="123";

    @Test
    public void batchInsert() {

        Connection conn = null;
        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);
            Date createTime = new Date(System.currentTimeMillis());
            String sql = "INSERT INTO indnetinfo(customerId,indentPrice,payTime,payType) VALUES(?,?,?,0)";

            ps = conn.prepareStatement(sql);

            long start = System.currentTimeMillis();

            for (int i = 0; i < 1000000; i++) {
                ps.setInt(1,i);
                ps.setDouble(2,2.50);
                ps.setDate(3, createTime);
                ps.addBatch();
            }
            ps.executeBatch();
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
