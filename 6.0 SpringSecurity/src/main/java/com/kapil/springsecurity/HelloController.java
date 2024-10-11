package com.kapil.springsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;


//for get request, spring security handles csrf token implicitly, but for put,post,delete, we need to
//add csrf token in header
@RestController
public class HelloController {

//1

    @GetMapping("hello")
    public String greeting(HttpServletRequest request) {
        return "Hello World " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "about us " + request.getSession().getId();
    }

    @PostMapping("student")
    public String student(@RequestBody Student student) {
        return "hello " + student.getName();
    }
}
