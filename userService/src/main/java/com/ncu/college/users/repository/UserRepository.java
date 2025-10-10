package com.ncu.college.users.repository;

import java.util.List;
import com.ncu.college.users.repository.UserRowMapper;
import com.ncu.college.users.irepository.IUserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ncu.college.users.model.User;


@Repository(value = "UserRepository")
public class UserRepository implements IUserRepository {

    JdbcTemplate _jdbcTemplate;

    @Autowired
    UserRepository(JdbcTemplate jdbcTemplate) {
        this._jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> GetAllUsers() {
        List<User> users;
        String sql = "select * from users";

        try {
            users = _jdbcTemplate.query(sql, new UserRowMapper());
            return users;
        } catch (Exception e) {
            System.out.println("Error fetching users :" + e.getMessage());
            return null;
        }
    }

    @Override
    public User GetUserById(String userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return _jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching user by id :" + e.getMessage());
            return null;
        }
    }

     @Override
    public int AddUser(User user) {
        // String sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
        try {
            return 1;
        } catch (Exception e) {
            System.out.println("Error adding user :" + e.getMessage());
            return 0;
        }
    }
}
