package com.learntony.microservice.productservice.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequestDto {
    private String name;
    private BigDecimal price;
}
