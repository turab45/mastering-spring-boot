package com.watsy.daoimpl;

import com.watsy.dao.PostDao;
import com.watsy.entities.PostEntity;
import com.watsy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostDaoImpl implements PostDao {

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostEntity addOrUpdatePost(PostEntity postEntity) {
        return null;
    }

    @Override
    public Integer deletePost(Integer id) {
        return null;
    }

    @Override
    public PostEntity getPostById(Integer id) {
        return null;
    }

    @Override
    public Set<PostEntity> getAllPosts() {
        return null;
    }
}
