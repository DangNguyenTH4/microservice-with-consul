package com.learntony.microservice.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntony.microservice.orderservice.client.AccountClient;
import com.learntony.microservice.orderservice.client.CustomerClient;
import com.learntony.microservice.orderservice.client.ProductClient;
import com.learntony.microservice.orderservice.dto.request.PrepareOrderRequestDto;
import com.learntony.microservice.orderservice.dto.response.PrepareOrderResponseDto;
import com.learntony.microservice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
public class OrderController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    OrderService service;
    @Autowired
    AccountClient accountClient;
    @Autowired
    CustomerClient customerClient;
    @Autowired
    ProductClient productClient;

    @PostMapping
    public PrepareOrderResponseDto prepare(@RequestBody PrepareOrderRequestDto order) throws JsonProcessingException {
        int price = 0;
        List<Object> products = productClient.findByIds(order.getProductIds());
        log.info("Products found: {}", mapper.writeValueAsString(products));
        Object customer = customerClient.findByIdWithAccounts(order.getCustomerId());
        log.info("Customer found: {}", mapper.writeValueAsString(customer));
//        for (Product product : products)
//            price += product.getPrice();
//        final int priceDiscounted = priceDiscount(price, customer);
//        LOGGER.info("Discounted price: {}", mapper.writeValueAsString(Collections.singletonMap("price", priceDiscounted)));
//        Optional<Account> account = customer.getAccounts().stream().filter(a -> (a.getBalance() > priceDiscounted)).findFirst();
//        if (account.isPresent()) {
//            order.setAccountId(account.get().getId());
//            order.setStatus(OrderStatus.ACCEPTED);
//            order.setPrice(priceDiscounted);
//            LOGGER.info("Account found: {}", mapper.writeValueAsString(account.get()));
//        } else {
//            order.setStatus(OrderStatus.REJECTED);
//            LOGGER.info("Account not found: {}", mapper.writeValueAsString(customer.getAccounts()));
//        }
//        Map<String, String> m = MDC.getCopyOfContextMap();
        return service.add(order);
    }

    @PutMapping("/{id}")
    public Object accept(@PathVariable String id) throws JsonProcessingException {
        final Object order = service.findById(id);
//        log.info("Order found: {}", mapper.writeValueAsString(order));
//        accountClient.withdraw(order.getAccountId(), order.getPrice());
//        HashMap<String, Object> log = new HashMap<>();
//        log.put("accountId", order.getAccountId());
//        log.put("price", order.getPrice());
//        LOGGER.info("Account modified: {}", mapper.writeValueAsString(log));
//        order.setStatus(OrderStatus.DONE);
//        LOGGER.info("Order status changed: {}", mapper.writeValueAsString(Collections.singletonMap("status", order.getStatus())));
//        service.update(order);
        return order;
    }

//    private int priceDiscount(int price, Customer customer) {
//        double discount = 0;
//        switch (customer.getType()) {
//            case REGULAR:
//                discount += 0.05;
//                break;
//            case VIP:
//                discount += 0.1;
//                break;
//
//            default:
//                break;
//        }
//        int ordersNum = service.countByCustomerId(customer.getId());
//        discount += (ordersNum*0.01);
//        return (int) (price - (price * discount));
//    }

}
