package com.learntony.microservice.customerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.customerservice.client.AccountClient;
import com.learntony.microservice.customerservice.dto.request.AddCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.request.UpdateCustomerRequestDto;
import com.learntony.microservice.customerservice.dto.response.AddCustomerResponseDto;
import com.learntony.microservice.customerservice.dto.response.UpdateCustomerResponseDto;
import com.learntony.microservice.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    AccountClient accountClient;
    @Autowired
    CustomerService service;

    @PostMapping
    public AddCustomerResponseDto add(@RequestBody AddCustomerRequestDto customer) {
        return service.add(customer);
    }

    @PutMapping
    public UpdateCustomerResponseDto update(@RequestBody UpdateCustomerRequestDto customer) {
        return service.update(customer);
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/withAccounts/{id}")
    public Object findByIdWithAccounts(@PathVariable("id") Long id) throws JsonProcessingException {
        List<Object> accounts = accountClient.findByCustomer(id);
        log.info("Accounts found: {}", mapper.writeValueAsString(accounts));
        return service.findById(id);
//        c.setAccounts(accounts);
//        return c;
    }

    @PostMapping("/ids")
    public List<Object> find(@RequestBody List<Long> ids) {
        return service.find(ids);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
