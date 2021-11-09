package com.learntony.microservice.productservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.productservice.dto.request.AddProductRequestDto;
import com.learntony.microservice.productservice.dto.request.UpdateProductRequestDto;
import com.learntony.microservice.productservice.dto.response.AddProductResponseDto;
import com.learntony.microservice.productservice.dto.response.ProductInfoResponseDto;
import com.learntony.microservice.productservice.dto.response.UpdateProductResponseDto;
import com.learntony.microservice.productservice.model.ProductEntity;
import com.learntony.microservice.productservice.repository.ProductRepository;
import com.learntony.microservice.productservice.service.ProductService;
import com.learntony.microservice.productservice.util.JacksonUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public AddProductResponseDto add(AddProductRequestDto product) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductEntity entity = objectMapper.convertValue(product, ProductEntity.class);
        entity = repository.save(entity);

        AddProductResponseDto dto = objectMapper.convertValue(entity, AddProductResponseDto.class);
        return dto;
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto product) {
        return repository.findById(product.getId())
                .map(entity -> {
            entity.setName(product.getName());
            entity.setPrice(product.getPrice());
            repository.save(entity);
            UpdateProductResponseDto responseDto = new ObjectMapper().convertValue(entity, UpdateProductResponseDto.class);
            return responseDto;
        }).orElse(null);
    }

    @Override
    public ProductInfoResponseDto findById(String id) {
        return repository.findById(id).map(
                entity->{
                    return new ObjectMapper().convertValue(entity, ProductInfoResponseDto.class);
                }).orElse(null);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductInfoResponseDto> find(List<String> ids) {
        return repository.findAllById(ids).stream().map( entity-> {
                    return new ObjectMapper().convertValue(entity, ProductInfoResponseDto.class);
                }).collect(Collectors.toList());
    }
}
