package com.watsy.dao;

import com.watsy.entities.GroupEntity;

import java.util.Set;

public interface GroupDao {
    GroupEntity addOrUpdateGroup(GroupEntity groupEntity);
    Integer deleteGroup(Integer id);
    GroupEntity getGroupById(Integer id);
    GroupEntity getGroupByTitle(String title);
    Set<GroupEntity> getAllGroups();
}
