package com.learntony.microservice.authservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfoResponseDto {
    private String id;
    private String name;
    private BigDecimal price;
    private Date created;
    private Date updated;
}
