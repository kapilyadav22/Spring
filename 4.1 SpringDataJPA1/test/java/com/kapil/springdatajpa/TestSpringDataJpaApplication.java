package com.kapil.springdatajpa;

import org.springframework.boot.SpringApplication;

public class TestSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringDataJpaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
