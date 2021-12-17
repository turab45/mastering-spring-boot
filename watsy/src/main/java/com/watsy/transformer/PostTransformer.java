package com.watsy.transformer;

import com.watsy.dto.PostDTO;
import com.watsy.entities.PostEntity;

import java.util.HashSet;
import java.util.Set;

public class PostTransformer {

    public static PostDTO toPostDTO(PostEntity postEntity){
        PostDTO postDTO = new PostDTO();

        if (postEntity.getId() != null)
            postDTO.setId(postEntity.getId().toString());
        if (postEntity.getContent() != null)
            postDTO.setContent(postEntity.getContent());
        if (postEntity.getUser() != null)
            postDTO.setUser(UserTransformer.toUserDTO(postEntity.getUser()));

        return postDTO;
    }

    public Set<PostDTO> toPostDTO(Set<PostEntity> posts){
        Set<PostDTO> postDTOS = new HashSet<>();

        for (PostEntity postEntity: posts)
            postDTOS.add(toPostDTO(postEntity));

        return postDTOS;
    }
}
