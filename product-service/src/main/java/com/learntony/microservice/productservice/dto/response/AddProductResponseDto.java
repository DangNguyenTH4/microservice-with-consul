package com.learntony.microservice.productservice.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProductResponseDto {
    private String id;
    private String name;
    private BigDecimal price;
}
