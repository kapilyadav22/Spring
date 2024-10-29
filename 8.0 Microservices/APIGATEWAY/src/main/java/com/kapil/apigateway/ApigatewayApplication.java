package com.kapil.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

// Spring Cloud Gateway includes built-in support for load balancing when using Spring Cloud LoadBalancer. It can distribute incoming requests across multiple instances of a service,
// either registered with a service registry (like Eureka) or configured manually.

public class ApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }

}


