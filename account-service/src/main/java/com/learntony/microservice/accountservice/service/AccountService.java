package com.learntony.microservice.accountservice.service;

import com.learntony.microservice.accountservice.dto.request.AddAccountRequestDto;
import com.learntony.microservice.accountservice.dto.request.UpdateAccountRequestDto;
import com.learntony.microservice.accountservice.dto.response.AddAccountResponseDto;
import com.learntony.microservice.accountservice.dto.response.UpdateAccountResponseDto;

import java.util.List;

public interface AccountService {
    AddAccountResponseDto add(AddAccountRequestDto obj);
    UpdateAccountResponseDto update(UpdateAccountRequestDto obj);
    Object delete(String id);
    Object findById(String id);
    List<Object> findByCustomer(String id);
    List<Object> find(List<String> ids);
}
