package com.learntony.microservice.productservice.service.impl;

import com.learntony.microservice.productservice.dto.request.AddProductRequestDto;
import com.learntony.microservice.productservice.dto.request.UpdateProductRequestDto;
import com.learntony.microservice.productservice.dto.response.AddProductResponseDto;
import com.learntony.microservice.productservice.dto.response.UpdateProductResponseDto;
import com.learntony.microservice.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public AddProductResponseDto add(AddProductRequestDto product) {
        return null;
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto product) {
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
