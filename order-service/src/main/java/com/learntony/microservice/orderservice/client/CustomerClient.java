package com.learntony.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

	@GetMapping("/withAccounts/{customerId}")
	Object findByIdWithAccounts(@PathVariable("customerId") String customerId);
	
}
