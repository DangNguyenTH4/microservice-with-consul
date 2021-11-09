package com.learntony.microservice.accountservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.accountservice.dto.request.AddAccountRequestDto;
import com.learntony.microservice.accountservice.dto.request.UpdateAccountRequestDto;
import com.learntony.microservice.accountservice.dto.response.AddAccountResponseDto;
import com.learntony.microservice.accountservice.dto.response.UpdateAccountResponseDto;
import com.learntony.microservice.accountservice.model.AccountEntity;
import com.learntony.microservice.accountservice.repository.AccountRepository;
import com.learntony.microservice.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Override
    public AddAccountResponseDto add(AddAccountRequestDto obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        AccountEntity entity = objectMapper.convertValue(obj, AccountEntity.class);
        repository.save(entity);
        return objectMapper.convertValue(entity, AddAccountResponseDto.class);


    }

    @Override
    public UpdateAccountResponseDto update(UpdateAccountRequestDto obj) {
        return null;
    }

    @Override
    public Object delete(String obj) {
        return null;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public List<Object> findByCustomer(String id) {
        return null;
    }

    @Override
    public List<Object> find(List<String> ids) {
        return null;
    }
}
