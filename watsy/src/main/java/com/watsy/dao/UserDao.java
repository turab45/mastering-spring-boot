package com.watsy.dao;

import com.watsy.entities.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserDao {
    UserEntity addOrUpdateUser(UserEntity userEntity);
    Integer deleteUser(Integer id);
    UserEntity getUserById(Integer id);
    UserEntity getUserByName(String name);
    List<UserEntity> getAllUsers();

}
