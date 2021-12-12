package com.watsy.daoimpl;

import com.watsy.dao.GroupDao;
import com.watsy.entities.GroupEntity;
import com.watsy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private GroupRepository groupRepository;

    
    @Override
    public GroupEntity addOrUpdateGroup(GroupEntity groupEntity) {
        return null;
    }

    @Override
    public Integer deleteGroup(Integer id) {
        return null;
    }

    @Override
    public GroupEntity getGroupById(Integer id) {
        return null;
    }

    @Override
    public GroupEntity getGroupByTitle(String title) {
        return null;
    }

    @Override
    public Set<GroupEntity> getAllGroups() {
        return null;
    }
}
