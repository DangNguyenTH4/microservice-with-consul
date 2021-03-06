package com.learntony.microservice.productservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductResponseDto {
    private String id;
    private String name;
    private BigDecimal price;
}
