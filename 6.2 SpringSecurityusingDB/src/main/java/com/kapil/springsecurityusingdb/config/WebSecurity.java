package com.kapil.springsecurityusingdb.config;

import com.kapil.springsecurityusingdb.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Autowired
    private CustomUserService customUserService;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //we are checking role for AntPathRequestMatcher("/transfer") paths
        //use /** to check for  every path

        http.csrf(e->e.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers(new AntPathRequestMatcher("/admin")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/user")).hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/contactus").permitAll()
                        .anyRequest().authenticated()
                )
//                .userDetailsService(customUserService)
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }
}
