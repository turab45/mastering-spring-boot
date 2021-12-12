package com.watsy.daoimpl;

import com.watsy.dao.UserDao;
import com.watsy.entities.UserEntity;
import com.watsy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity addOrUpdateUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public Integer deleteUser(Integer id) {
        return null;
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return null;
    }

    @Override
    public UserEntity getUserByName(String name) {
        return null;
    }

    @Override
    public Set<UserEntity> getAllUsers() {
        return null;
    }
}
