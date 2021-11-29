package com.sociallapp.controller;

import com.sociallapp.daoimpl.PostDaoImpl;
import com.sociallapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostDaoImpl postDaoImpl;

    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") Integer id){
        return postDaoImpl.getById(id);
    }
}
