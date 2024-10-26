package com.kapil.springsecurityjwttoken.Controller;

import com.kapil.springsecurityjwttoken.DTO.AuthenticationResponse;
import com.kapil.springsecurityjwttoken.DTO.LoginRequest;
import com.kapil.springsecurityjwttoken.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = authenticationService.authenticateAndGenerateToken(
                    loginRequest.getUsername(), loginRequest.getPassword());

            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}

