package com.watsy.dao;

import com.watsy.entities.PostEntity;

import java.util.Set;

public interface PostDao {
    PostEntity addOrUpdatePost(PostEntity postEntity);
    Integer deletePost(Integer id);
    PostEntity getPostById(Integer id);
    Set<PostEntity> getAllPosts();
}
