package com.kapil.secondmicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    Environment env;

    @GetMapping("/")
    public String hello() {
        String port = env.getProperty("server.port");
        return "Second Microservice is "+ "running on port " + port;
    }
}
