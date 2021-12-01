package com.sociallapp.daoimpl;

import com.sociallapp.model.Post;
import com.sociallapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PostRowMapper implements RowMapper<Post> {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        User author = this.userDaoImpl.getById(rs.getInt(5));

        post.setId(rs.getInt(1));
        post.setContent(rs.getString(2));
        post.setDate(rs.getString(3));
        post.setAuthor(author);

        return post;
    }
}
