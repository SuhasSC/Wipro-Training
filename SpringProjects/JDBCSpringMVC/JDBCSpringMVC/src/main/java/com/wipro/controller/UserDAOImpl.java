package com.wipro.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public void saveUser(UserModel user) {

        String sql =
        "INSERT INTO users(id, name, email) VALUES(?,?, ?)";

        jdbcTemplate.update(
                sql,
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    
    public java.util.List getUser() {
        return null;
    }
}