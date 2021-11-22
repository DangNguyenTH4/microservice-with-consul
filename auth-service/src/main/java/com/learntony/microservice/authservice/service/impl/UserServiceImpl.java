package com.learntony.microservice.authservice.service.impl;

import com.learntony.microservice.authservice.model.RoleEntity;
import com.learntony.microservice.authservice.model.UserEntity;
import com.learntony.microservice.authservice.repository.RoleRepository;
import com.learntony.microservice.authservice.repository.UserRepository;
import com.learntony.microservice.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        UserEntity user = userRepository.findByUserName(userName);
        RoleEntity role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserEntity getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
