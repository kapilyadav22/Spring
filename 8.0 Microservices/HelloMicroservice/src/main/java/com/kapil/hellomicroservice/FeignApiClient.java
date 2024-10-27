package com.kapil.hellomicroservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="SecondMicroservice")
public interface FeignApiClient {

    @GetMapping("/")
    String hello();
}
