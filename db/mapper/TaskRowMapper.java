package com.springLearn.springApp.db.mapper;

import com.springLearn.springApp.model.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt( "id"));
        task.setTitle(rs.getString( "title"));
        return task;
    }

}