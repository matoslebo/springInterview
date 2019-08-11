package com.springLearn.springApp.db.mapper;

import com.springLearn.springApp.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt( "id"));
        category.setTitle(rs.getString( "title"));
        return category;
    }

}
