package com.learntony.microservice.authservice.service;

import com.learntony.microservice.authservice.model.RoleEntity;
import com.learntony.microservice.authservice.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity saveUser(UserEntity user);
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String userName, String roleName);
    UserEntity getUser(String userName);
    List<UserEntity> getUsers();
}
