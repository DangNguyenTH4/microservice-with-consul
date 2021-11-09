package com.learntony.microservice.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrepareOrderRequestDto {
    private String customerId;
    private List<String> productIds;

}
