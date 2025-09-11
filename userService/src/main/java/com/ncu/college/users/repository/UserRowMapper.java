package com.ncu.college.users.repository;

import org.springframework.jdbc.core.RowMapper;
import com.ncu.college.users.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs == null) {
            return null;
        }

        User user = new User();
        user.setUserId(rs.getString("user_id"));   // maps to column user_id
        user.setName(rs.getString("name"));       // maps to column name
        user.setPassword(rs.getString("password"));// maps to column password

        return user;
    }
}
 