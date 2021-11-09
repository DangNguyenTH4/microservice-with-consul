package com.learntony.microservice.orderservice.service.impl;

import com.learntony.microservice.orderservice.dto.request.PrepareOrderRequestDto;
import com.learntony.microservice.orderservice.dto.response.PrepareOrderResponseDto;
import com.learntony.microservice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public PrepareOrderResponseDto add(PrepareOrderRequestDto order) {
        return null;
    }

    @Override
    public Object update(Object order) {
        return null;
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

    @Override
    public int countByCustomerId(String customerId) {
        return 0;
    }
}
