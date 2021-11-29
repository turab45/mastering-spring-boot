package com.sociallapp.daoimpl;

import com.sociallapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PostRowMapper implements RowMapper<Post> {
    @Autowired
    Post post;
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        post.setId(rs.getInt(1));
        post.setContent(rs.getString(2));
        post.setDate(rs.getString(3));
        post.setAuthor(rs.getString(4));

        return post;
    }
}
