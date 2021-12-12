package com.watsy.daoimpl;

import com.watsy.dao.UserDao;
import com.watsy.entities.UserEntity;
import com.watsy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity addOrUpdateUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
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
    public List<UserEntity> getAllUsers() {
        return (List) this.userRepository.findAll();
    }
}
