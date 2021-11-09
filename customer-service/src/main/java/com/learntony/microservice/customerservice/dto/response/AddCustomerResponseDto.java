package com.learntony.microservice.customerservice.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learntony.microservice.customerservice.constant.CustomerType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddCustomerResponseDto {
    private String id;
    private String name;
    private CustomerType type;
}
