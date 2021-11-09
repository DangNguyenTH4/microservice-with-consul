package com.learntony.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

	@PostMapping("/ids")
	List<Object> findByIds(List<String> ids);
	
}
