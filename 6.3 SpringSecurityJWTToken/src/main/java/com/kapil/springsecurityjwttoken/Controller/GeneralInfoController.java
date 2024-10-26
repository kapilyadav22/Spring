package com.kapil.springsecurityjwttoken.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralInfoController {

    @GetMapping("/homePage")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/contactus")
    public String contactUs() {
        return "singhkapil347@gmail.com";
    }

}
