package com.sociallapp.controller;

import com.sociallapp.daoimpl.PostDaoImpl;
import com.sociallapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostDaoImpl postDaoImpl;

    @GetMapping("/getById/{id}")
    public Post getById(@PathVariable("id") Integer id){
        return postDaoImpl.getById(id);
    }

    @PostMapping("/addOrUpdate")
    public Post addOrUpdatePost(@RequestBody Post post){
        return this.postDaoImpl.addOrUpdate(post);
    }

    @PostMapping("/bulkAddOrUpdate")
    public List<Post> bulkAddOrUpdatePost(@RequestBody List<Post> posts){
        List<Post> addedPosts = new ArrayList<>();
        for (Post post: posts)
            addedPosts.add(this.postDaoImpl.addOrUpdate(post));

        return addedPosts;
    }

    @GetMapping("/getAll")
    public List<Post> getAll(){
        return this.postDaoImpl.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        int res = this.postDaoImpl.delete(id);
        if (res > 0)
            return "Deleted Successfully.";
        return "Something went wrong!";
    }
}
