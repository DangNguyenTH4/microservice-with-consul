package com.learntony.microservice.customerservice.service;

import com.learntony.microservice.customerservice.dto.request.AddCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.request.UpdateCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.response.AddCustomerResponseDto;
import com.learntony.microservice.customerservice.dto.response.UpdateCustomerResponseDto;

import java.util.List;

public interface CustomerService {

    AddCustomerResponseDto add(AddCustomerRequestDto customer) ;

    UpdateCustomerResponseDto update(UpdateCustomerRequestDto customer) ;

    Object findById(String id) ;

    void delete(String id) ;

    List<Object> find(List<String> ids) ;
}
