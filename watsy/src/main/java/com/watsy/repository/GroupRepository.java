package com.watsy.repository;

import com.watsy.entities.GroupEntity;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<GroupEntity, Integer> {
}
