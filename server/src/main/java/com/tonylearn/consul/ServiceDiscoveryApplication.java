package com.tonylearn.consul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceDiscoveryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceDiscoveryApplication.class).run(args);
	}

}
