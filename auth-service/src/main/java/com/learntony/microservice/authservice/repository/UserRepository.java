package com.learntony.microservice.authservice.repository;

import com.learntony.microservice.authservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String username);
}
