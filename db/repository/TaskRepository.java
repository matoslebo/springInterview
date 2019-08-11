package com.springLearn.springApp.db.repository;

import com.springLearn.springApp.db.mapper.TaskRowMapper;
import com.springLearn.springApp.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Component
public class TaskRepository {
    private final JdbcTemplate jdbcTemplate;
    private final TaskRowMapper taskRowMapper = new TaskRowMapper();

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void remove(int id) {
         String sql = "delete from task where task.id = ?";
        jdbcTemplate.update(sql, id);

    }

    public Integer add(Task task) {
        final String sql = "INSERT INTO `task` (`title`, `idcategory`) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, task.getTitle());
                ps.setInt(2, task.getIdcategory());
                return ps;
            }
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Task> getAll() {
        final String sql = "Select task.id, task.title, category.title from task inner join category on task.idcategory = category.id";
        return jdbcTemplate.query(sql, taskRowMapper);
    }
}

