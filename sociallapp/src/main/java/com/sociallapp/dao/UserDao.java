package com.sociallapp.dao;

import com.sociallapp.model.User;

import java.util.List;

public interface UserDao {
    User addOrUpdate(User user);
    Integer delete(Integer id);
    List<User> getAll();
    User getById(Integer id);
    User getByUserName(String userName);
}
