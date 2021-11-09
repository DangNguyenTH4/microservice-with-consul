package com.learntony.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "account-service")
public interface AccountClient {

	@PutMapping("/withdraw/{accountId}/{amount}")
	Object withdraw(@PathVariable("accountId") String id, @PathVariable("amount") int amount);

}
