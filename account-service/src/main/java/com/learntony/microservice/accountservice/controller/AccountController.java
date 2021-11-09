package com.learntony.microservice.accountservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.accountservice.dto.request.AddAccountRequestDto;
import com.learntony.microservice.accountservice.dto.request.UpdateAccountRequestDto;
import com.learntony.microservice.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("")
public class AccountController {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private AccountService service;

    @PostMapping
    public Object add(@RequestBody AddAccountRequestDto account) {
        return service.add(account);
    }

    @PutMapping
    public Object update(@RequestBody UpdateAccountRequestDto account) {
        return service.update(account);
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Object withdraw(@PathVariable("id") Long id, @PathVariable("amount") int amount) throws JsonProcessingException {
        UpdateAccountRequestDto accountDto = new UpdateAccountRequestDto();
        return service.update(accountDto);
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Object> findByCustomerId(@PathVariable("customerId") String customerId) {
        return service.findByCustomer(customerId);
    }

    @PostMapping("/ids")
    public List<Object> find(@RequestBody List<String> ids) {
        return service.find(ids);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
