package com.watsy.transformer;

import com.watsy.dto.GroupDTO;
import com.watsy.entities.GroupEntity;

import java.util.HashSet;
import java.util.Set;

public class GroupTransformer {

    public static GroupDTO toGroupDTO(GroupEntity groupEntity){
        GroupDTO groupDTO = new GroupDTO();

        if (groupEntity.getId() != null)
            groupDTO.setId(groupEntity.getId().toString());
        if (groupEntity.getTitle() != null)
            groupDTO.setTitle(groupEntity.getTitle());

        return groupDTO;
    }

    public static Set<GroupDTO> toGroupDTO(Set<GroupEntity> groupEntities){
        Set<GroupDTO> groupDTOS = new HashSet<>();

        for (GroupEntity groupEntity: groupEntities)
            groupDTOS.add(toGroupDTO(groupEntity));

        return groupDTOS;
    }
}
