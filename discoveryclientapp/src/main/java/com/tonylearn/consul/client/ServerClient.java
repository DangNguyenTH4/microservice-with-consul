package com.tonylearn.consul.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

@Component
@Slf4j
public class ServerClient {
    @Autowired
    private RestTemplate restTemplate;

    public String callOtherService() {
        String response = restTemplate.exchange("http://myApp/client/get",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, "21`3").getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "School Name -  "  + " :::  Student Details " + response + " -  " + new Date();
    }
    public String call(URI uri){
//        String result = restTemplate.getForObject(uri.toString(),String.class);
        String result = restTemplate.getForObject("http://myApp/ping",String.class);
        log.info("Call result");

        return result;
    }

}
