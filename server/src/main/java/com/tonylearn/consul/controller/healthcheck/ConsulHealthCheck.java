package com.tonylearn.consul.controller.healthcheck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsulHealthCheck {
    @GetMapping("/my-health-check")
    public ResponseEntity<?> customHealthCheck(){
        log.info("Health check");
        return ResponseEntity.ok(null);
    }
    @GetMapping("/client/get")
    public ResponseEntity<?> forclient(){
        log.info("Client called");
        return ResponseEntity.ok(null);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong from server service";
    }
}
