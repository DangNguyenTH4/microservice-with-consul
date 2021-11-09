package com.learntony.microservice.customerservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.customerservice.dto.request.AddCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.request.UpdateCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.response.AddCustomerResponseDto;
import com.learntony.microservice.customerservice.dto.response.UpdateCustomerResponseDto;
import com.learntony.microservice.customerservice.model.CustomerEntity;
import com.learntony.microservice.customerservice.repository.CustomerRepository;
import com.learntony.microservice.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    @Override
    public AddCustomerResponseDto add(AddCustomerRequestDto customer) {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerEntity entity = objectMapper.convertValue(customer, CustomerEntity.class);
        repository.save(entity);
        return objectMapper.convertValue(entity, AddCustomerResponseDto.class);
    }

    @Override
    public UpdateCustomerResponseDto update(UpdateCustomerRequestDto customer) {
        return repository.findById(customer.getId())
                .map(entity->{
                    return new ObjectMapper().convertValue(entity, UpdateCustomerResponseDto.class);
                }).orElse(null);
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Object> find(List<String> ids) {
        return null;
    }
}
