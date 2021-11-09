package com.learntony.microservice.accountservice.repository;

import com.learntony.microservice.accountservice.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
