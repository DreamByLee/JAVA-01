package io.work03;

import ch.qos.logback.core.db.dialect.DBUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leeyj
 * @date 2021/2/19 13:01
 */
@Slf4j
@Repository
public class JdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertStudent() {
        Arrays.asList("张无忌","周芷若").forEach(student->{
            jdbcTemplate.update("INSERT INTO STUDENT (NAME) VALUES (?)", student);
        });
    }

    public void removeStudent() {
        jdbcTemplate.update("DELETE FROM STUDENT WHERE ID=?", 1);
        log.info("DELETE->");
    }

    public void updateStudent() {
        jdbcTemplate.update("UPDATE STUDENT SET NAME = ? WHERE ID=?", "张三","2");
        log.info("UPDATE->");
    }

    public void queryStudent() {
        List<Student> students = jdbcTemplate.query("SELECT * FROM STUDENT", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return Student.builder()
                        .id(resultSet.getLong(1))
                        .name(resultSet.getString(2)).build();
            }
        });
        students.forEach(s -> log.info("Student:{}", s));
    }


    public void batchInsert() {
        jdbcTemplate.batchUpdate("INSERT INTO STUDENT (NAME) VALUES (?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, "DreamByLee-" + i);
            }
            @Override
            public int getBatchSize() {
                return 10;
            }
        });
    }
}
