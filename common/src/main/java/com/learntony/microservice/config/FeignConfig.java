package com.learntony.microservice.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
public class FeignConfig {
    public class Common {
        @Bean
        public RequestInterceptor
        requestInterceptor() {
            log.info("Common Feign Interceptor");
            return requestTemplate -> {
                requestTemplate.header("Content-Type", "application/json");
                requestTemplate.header("Accept", "application/json");
                requestTemplate.header("header_1", "value_1");
            };
        }
    }
}
