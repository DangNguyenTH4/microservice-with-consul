package com.learntony.microservice.accountservice.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddAccountResponseDto {
    private String id;
    private String number;
    private BigDecimal balance;
    private String customerId;
}
