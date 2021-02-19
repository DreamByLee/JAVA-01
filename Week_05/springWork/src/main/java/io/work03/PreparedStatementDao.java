package io.work03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author Leeyj
 * @date 2021/2/19 13:54
 */
@Slf4j
@Repository
public class PreparedStatementDao {

    @Autowired
    private DataSource dataSource;

    PreparedStatement ps = null;
    Connection conn = null;

    public void getConn() throws SQLException {
        conn = dataSource.getConnection();
        conn.setAutoCommit(false);
    }

    public void closeConn() throws SQLException {
        ps.close();
        conn.close();
    }

    public void insertStudent() {
        try {
            ps = conn.prepareStatement("INSERT INTO STUDENT (ID,NAME) VALUES (?,?)");
            ps.setLong(1,5);
            ps.setString(2,"李焕英");

            int resultNum = ps.executeUpdate();

            conn.commit();
            if (resultNum > 0) {
                log.info("新增成功");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            log.error("数据库访问异常");
            e.printStackTrace();
        }
        /*finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.error("资源释放异常");
            }
        }*/
    }

    public void updateStudent() {
        try {
            ps = conn.prepareStatement("UPDATE STUDENT SET NAME = ? WHERE ID=?");
            ps.setString(1,"张小斐");
            ps.setLong(2, 3);
            int resultNum = ps.executeUpdate();
            conn.commit();
            if (resultNum > 0) {
                log.info("修改成功");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            log.error("数据库访问异常");
            e.printStackTrace();
        }
    }

    public void removeStudent() {
        try {
            ps = conn.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
            ps.setString(1,"10");
            int resultNum = ps.executeUpdate();
            conn.commit();
            if (resultNum > 0) {
                log.info("删除成功");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                log.info("删除操作事务回滚。。。。");
                ex.printStackTrace();
            }
            log.error("数据库访问异常");
            e.printStackTrace();
        }
    }

    public void queryStudent() {
        try {
            ps = conn.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student students = new Student(rs.getLong("id"), rs.getString("name"));
                log.info("Student->{}",students);
            }
        } catch (SQLException e) {
            log.error("数据库访问异常");
            e.printStackTrace();
        }
    }


}
