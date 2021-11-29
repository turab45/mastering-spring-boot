package com.sociallapp.daoimpl;

import com.sociallapp.dao.PostDao;
import com.sociallapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    PostRowMapper rowMapper;
    String query = "";

    @Override
    public Post addOrUpdate(Post post) {
        if (post.getId() == null){
            query = "INSERT INTO post(post_content,post_date,post_author) VALUES(?,?,?)";
            int id = this.jdbcTemplate.update(query, post.getContent(), post.getDate(), post.getAuthor());
            return this.getById(id);
        }

        query = "UPDATE post SET post_content=?, post_date=?, post_author=? WHERE id=?";
        int id = this.jdbcTemplate.update(query, post.getContent(), post.getDate(), post.getAuthor(), post.getId());
        return this.getById(id);
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public Post getById(Integer id) {
        query = "SELECT * FROM post WHERE id=?";
        Post post = this.jdbcTemplate.queryForObject(query, rowMapper, id);
        return post;
    }
}
