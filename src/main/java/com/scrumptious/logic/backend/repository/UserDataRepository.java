package com.scrumptious.logic.backend.repository;

import com.scrumptious.logic.backend.entity.UserData;

import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData, Long> {
    UserData findByEmail(String email);
    UserData deleteByEmail(String email);
    UserData findByDisplayName(String displayName);
}
