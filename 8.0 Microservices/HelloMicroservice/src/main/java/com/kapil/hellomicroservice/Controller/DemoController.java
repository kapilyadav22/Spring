package com.kapil.hellomicroservice.Controller;

import com.kapil.hellomicroservice.FeignApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//
//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    FeignApiClient feignApiClient;

    @GetMapping("/")
    public String hello() {
//        String res = restTemplate.getForObject("http://localhost:8080", String.class);
        String res = feignApiClient.hello();

        return "Hello from First Microservice to "+ res;
    }
}
