package com.learntony.microservice.productservice.service;

import com.learntony.microservice.productservice.dto.request.AddProductRequestDto;
import com.learntony.microservice.productservice.dto.request.UpdateProductRequestDto;
import com.learntony.microservice.productservice.dto.response.AddProductResponseDto;
import com.learntony.microservice.productservice.dto.response.ProductInfoResponseDto;
import com.learntony.microservice.productservice.dto.response.UpdateProductResponseDto;

import java.util.List;

public interface ProductService {

    AddProductResponseDto add(AddProductRequestDto product) ;

    UpdateProductResponseDto update(UpdateProductRequestDto product) ;

    ProductInfoResponseDto findById(String id) ;

    void delete(String id);

    List<ProductInfoResponseDto> find(List<String> ids) ;
}
