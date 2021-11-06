package com.tonylearn.consul.controller;

import com.tonylearn.consul.client.ServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@RestController
public class DiscoveryClientController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ServerClient serverClient;

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("myApp")
                .stream()
                .findFirst()
                .map(si -> si.getUri());
    }

    @GetMapping("/discoveryClient")
    public String discoveryPing() throws RestClientException,
            ServiceUnavailableException {
        URI service = serviceUrl()
                .map(s -> s.resolve("/ping"))
                .orElseThrow(ServiceUnavailableException::new);
        return serverClient.call(service);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
