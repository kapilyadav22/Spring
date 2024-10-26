package com.kapil.springsecurityjwttoken.service;

import com.kapil.springsecurityjwttoken.entity.Users;
import com.kapil.springsecurityjwttoken.repo.UserRepo;
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
        Users users = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found"));
        return User.withUsername(users.getEmail())
                .password(users.getPassword())
                .roles(users.getRole())
                .build();
    }
}
