package com.learntony.microservice.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.productservice.dto.request.AddProductRequestDto;
import com.learntony.microservice.productservice.dto.request.UpdateProductRequestDto;
import com.learntony.microservice.productservice.dto.response.AddProductResponseDto;
import com.learntony.microservice.productservice.dto.response.ProductInfoResponseDto;
import com.learntony.microservice.productservice.dto.response.UpdateProductResponseDto;
import com.learntony.microservice.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class ProductController {


    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ProductService service;

    @PostMapping
    public AddProductResponseDto add(@RequestBody AddProductRequestDto product) {
        return service.add(product);
    }

    @PutMapping
    public UpdateProductResponseDto update(@RequestBody UpdateProductRequestDto product) {
        return service.update(product);
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping("/ids")
    public List<ProductInfoResponseDto> find(@RequestBody List<String> ids) throws JsonProcessingException {
        List<ProductInfoResponseDto> products = service.find(ids);
        log.info("Products found: {}", mapper.writeValueAsString(Collections.singletonMap("count", products.size())));
        return products;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
