package com.watsy.transformer;

import com.watsy.dto.UserDTO;
import com.watsy.entities.UserEntity;

import java.util.HashSet;
import java.util.Set;

public class UserTransformer {

    public static UserDTO toUserDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();

        if (user.getId() != null) {
            userDTO.setId(user.getId().toString());
        }
        if (user.getUsername() != null) {
            userDTO.setUsername(user.getUsername());
        }
        if (user.getEmail() != null) {
            userDTO.setEmail(user.getEmail());
        }


        return userDTO;

    }

    public static Set<UserDTO> toUserDTO(Set<UserEntity> allUsers){
        Set<UserDTO> allDtos = new HashSet<>();

        for(UserEntity user : allUsers) {
            UserDTO userDTO = UserTransformer.toUserDTO(user);
            allDtos.add(userDTO);
        }
        return allDtos;
    }
}
