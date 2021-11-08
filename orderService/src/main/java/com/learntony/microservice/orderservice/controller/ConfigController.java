package com.learntony.microservice.orderservice.controller;

import com.learntony.microservice.orderservice.config.MySQLProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
    @Autowired
    private MySQLProperties mySQLProperties;

    @Value("${name:noname}")
    private String name;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/mysql")
    public MySQLProperties getMySQLProperties() {
        return mySQLProperties;
    }
}
