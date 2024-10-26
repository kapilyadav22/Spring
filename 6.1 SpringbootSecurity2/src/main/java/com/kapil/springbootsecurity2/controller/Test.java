package com.kapil.springbootsecurity2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/contactus")
    public String contactus() {
        return "+91899998929";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/update")
    public String update() {
        return "XXXXXXX";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/transfer")
    public String transfer() {
        return "transfer 100 rs";
    }



}
