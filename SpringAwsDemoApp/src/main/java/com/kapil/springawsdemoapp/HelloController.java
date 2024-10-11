package com.kapil.springawsdemoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to Programming Hub";
    }

    @GetMapping("/info")
    public String info() {
        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String arch = System.getProperty("os.arch");
        String javaversion = System.getProperty("java.version");
        return "Hello, " + os + " " + version + " " + arch + " " + javaversion;
    }
}
