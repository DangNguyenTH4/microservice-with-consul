package com.learntony.microservice.accountservice.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddAccountRequestDto {
    private String number;
    private BigDecimal balance;
    private String customerId;
}
