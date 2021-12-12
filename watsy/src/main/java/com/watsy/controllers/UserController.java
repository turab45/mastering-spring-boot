package com.watsy.controllers;

import com.watsy.daoimpl.UserDaoImpl;
import com.watsy.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @PostMapping("/addOrUpdate")
    private UserEntity addUser(@RequestBody UserEntity userEntity){
        return this.userDaoImpl.addOrUpdateUser(userEntity);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAllUsers(){
        return this.userDaoImpl.getAllUsers();
    }
}
