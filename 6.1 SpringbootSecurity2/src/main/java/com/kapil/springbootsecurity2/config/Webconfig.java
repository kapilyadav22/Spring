package com.kapil.springbootsecurity2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Webconfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        //8447 is password
        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("8447")).roles("ADMIN").build();
        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("8447")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //we are checking role for AntPathRequestMatcher("/transfer") paths
        //use /** to check for  every path

        http.csrf(e->e.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers(new AntPathRequestMatcher("/transfer")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/update")).hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/contactus").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

    //     @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(req-> req.requestMatchers("/contactus","/update")
//                        .permitAll().anyRequest().authenticated())
//                .formLogin(withDefaults()).httpBasic(withDefaults());
//
//        return httpSecurity.build();
//    }
}
