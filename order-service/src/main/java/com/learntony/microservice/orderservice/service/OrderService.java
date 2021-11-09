package com.learntony.microservice.orderservice.service;

import com.learntony.microservice.orderservice.dto.request.PrepareOrderRequestDto;
import com.learntony.microservice.orderservice.dto.response.PrepareOrderResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface OrderService {

    PrepareOrderResponseDto add(PrepareOrderRequestDto order) ;

    Object update(Object order) ;

    Object findById(String id) ;

    void delete(String id);

    List<Object> find(List<String> ids);

    int countByCustomerId(String customerId);
}
