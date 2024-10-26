package com.kapil.springsecurityusingdb.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminMethod(){
        return "admin";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/user")
    public String userMethod(){
        return "user";
    }

    @GetMapping("/contactus")
    public String contactUs(){
        return "singhkapil347@gmail.com";
    }
}
