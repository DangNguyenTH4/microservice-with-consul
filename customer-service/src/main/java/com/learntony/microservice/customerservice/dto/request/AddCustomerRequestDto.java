package com.learntony.microservice.customerservice.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learntony.microservice.customerservice.constant.CustomerType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddCustomerRequestDto {
    private String name;
    private CustomerType type;
}
