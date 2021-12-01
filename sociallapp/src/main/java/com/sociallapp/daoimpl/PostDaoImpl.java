package com.sociallapp.daoimpl;

import com.sociallapp.dao.PostDao;
import com.sociallapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
            query = "INSERT INTO post(post_content,post_date,author_id) VALUES(?,?,?)";
            this.jdbcTemplate.update(query, post.getContent(), post.getDate(), post.getAuthor().getId());

            return this.getByContent(post.getContent());
        }

        query = "UPDATE post SET post_content=?, post_date=?, author_id=? WHERE id=?";
        int id = this.jdbcTemplate.update(query, post.getContent(), post.getDate(), post.getAuthor().getId(), post.getId());
        return this.getByContent(post.getContent());
    }

    @Override
    public Integer delete(Integer id) {
        query = "DELETE FROM post WHERE id=?";
        int res = this.jdbcTemplate.update(query, id);
        return res;
    }

    @Override
    public List<Post> getAll() {
        query = "SELECT * FROM post";
        List<Post> posts = this.jdbcTemplate.query(query, rowMapper);
        return posts;
    }

    @Override
    public Post getById(Integer id) {
        query = "SELECT * FROM post WHERE id=?";
        Post post = this.jdbcTemplate.queryForObject(query, rowMapper, id);
        return post;
    }

    @Override
    public Post getByContent(String content) {
        query = "SELECT * FROM post WHERE post_content=?";
        Post post = this.jdbcTemplate.queryForObject(query, rowMapper, content);
        return post;
    }
}
