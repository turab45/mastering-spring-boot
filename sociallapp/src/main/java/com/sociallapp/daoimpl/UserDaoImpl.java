package com.sociallapp.daoimpl;

import com.sociallapp.dao.UserDao;
import com.sociallapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRowMapper rowMapper;

    String query = "";
    Integer id = null;

    @Override
    public User addOrUpdate(User user) {
        if (user.getId() == null){
            query = "INSERT INTO users(name, email, password) VALUES(?,?,?)";
            id = this.jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword());
            return this.getByUserName(user.getName());
        }

        query = "UPDATE users SET name=?, email=?,password=? WHERE id=?";
        this.jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword(), user.getId());
        return this.getById(user.getId());
    }

    @Override
    public Integer delete(Integer id) {
        query = "DELETE FROM users WHERE id=?";
        int res = this.jdbcTemplate.update(query, id);
        return res;
    }

    @Override
    public List<User> getAll() {
        query = "SELECT * FROM users";
        List<User> users = this.jdbcTemplate.query(query, rowMapper);
        return users;
    }

    @Override
    public User getById(Integer id) {
        query = "SELECT * FROM users WHERE id=?";
        User user = this.jdbcTemplate.queryForObject(query, rowMapper, id);
        return user;
    }

    @Override
    public User getByUserName(String userName) {
        query = "SELECT * FROM users WHERE name=?";
        User user = this.jdbcTemplate.queryForObject(query, rowMapper, userName);
        return user;
    }
}
