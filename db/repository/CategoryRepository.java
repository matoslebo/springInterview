package com.springLearn.springApp.db.repository;


import com.springLearn.springApp.db.mapper.CategoryRowMapper;
import com.springLearn.springApp.model.Category;
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
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CategoryRowMapper categoryRowMapper = new CategoryRowMapper();

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Integer add(Category category) {
        final String sql = "INSERT INTO `category` (`title`) VALUES (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, category.getTitle());
                return ps;
            }
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Category> getAll() {
        final String sql = "select * from category";
        return jdbcTemplate.query(sql, categoryRowMapper);
    }
}


