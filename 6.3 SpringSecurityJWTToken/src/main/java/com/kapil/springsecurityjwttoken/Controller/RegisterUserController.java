package com.kapil.springsecurityjwttoken.Controller;

import com.kapil.springsecurityjwttoken.DTO.LoginRequest;
import com.kapil.springsecurityjwttoken.entity.Users;
import com.kapil.springsecurityjwttoken.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    RegisterUserService registerUserService;

    @PostMapping("")
    public void register(@RequestBody Users registerRequest) {
        registerUserService.registerUser(registerRequest);
    }
}
