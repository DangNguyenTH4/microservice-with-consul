package com.learntony.microservice.orderservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mysql")
@Data
public class MySQLProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;
}
