package com.sociallapp.dao;

import com.sociallapp.model.Post;

import java.util.List;

public interface PostDao {

    Post addOrUpdate(Post post);
    Integer delete(Integer id);
    List<Post> getAll();
    Post getById(Integer id);
}
