package com.learntony.microservice.customerservice.service.impl;

import com.learntony.microservice.customerservice.dto.request.AddCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.request.UpdateCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.response.AddCustomerResponseDto;
import com.learntony.microservice.customerservice.dto.response.UpdateCustomerResponseDto;
import com.learntony.microservice.customerservice.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public AddCustomerResponseDto add(AddCustomerRequestDto customer) {
        return null;
    }

    @Override
    public UpdateCustomerResponseDto update(UpdateCustomerRequestDto customer) {
        return null;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Object> find(List<Long> ids) {
        return null;
    }
}
