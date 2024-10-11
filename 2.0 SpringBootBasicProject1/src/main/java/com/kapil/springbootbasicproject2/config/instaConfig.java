package com.kapil.springbootbasicproject2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


//create config file for predefined classed and add bean manually
@Configuration
public class instaConfig {

    @Bean
    public LocalDateTime getInstance(){
        return LocalDateTime.now();
    }
}

