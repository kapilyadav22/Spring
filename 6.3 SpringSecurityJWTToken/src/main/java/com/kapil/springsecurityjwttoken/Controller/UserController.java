package com.kapil.springsecurityjwttoken.Controller;

import com.kapil.springsecurityjwttoken.enums.UserRole;
import com.kapil.springsecurityjwttoken.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/purchases")
    public String adminDashboard(@RequestHeader("Authorization") String authorizationHeader) {
       /*
         Get the Authentication object from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails;
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        } else {
            throw new RuntimeException("User details not found.");
        }
        */
        try {
            String token = jwtUtil.getTokenFromAuthentication(authorizationHeader);

            if (!jwtUtil.isTokenExpired(token)) {
                Claims claims = jwtUtil.extractAllClaims(token);
                String role = (String) claims.get("role");
                //role will be like ROLE_student, so take student substring and check, because ROLE_will be common to each role
                UserRole userRoleEnum = UserRole.valueOf(role.startsWith("ROLE_") ? role.substring(5).toUpperCase() : role.toUpperCase());

                return switch (userRoleEnum) {
                    case ADMIN -> "Welcome to the admin dashboard!";
                    case STUDENT -> "Welcome to the student dashboard!";
                    case USER -> "Welcome to the user dashboard!";
                    default -> throw new RuntimeException("You do not have the required access.");
                };
            } else {
                return "Invalid token!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/coursecontent")
    public String courseContent(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String token = jwtUtil.getTokenFromAuthentication(authorizationHeader);

            if (!jwtUtil.isTokenExpired(token)) {
                return "Course Content";
            } else {
                return "Invalid token!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("courses")
    public String Courses() {
        return "courses";
    }
}
