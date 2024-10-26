package com.kapil.springsecurityusingdb.service;

import com.kapil.springsecurityusingdb.entity.Users;
import com.kapil.springsecurityusingdb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     Users users =   userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found"));
     System.out.println(users.getRole());
    return User.withUsername(users.getEmail())
            .password(users.getPassword())
            .roles(users.getRole())
            .build();
    }
}
