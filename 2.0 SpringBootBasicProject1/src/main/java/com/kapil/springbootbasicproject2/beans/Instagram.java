package com.kapil.springbootbasicproject2.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Instagram {

    @Autowired
    Reels reel;

    @Autowired
    LocalDateTime localDateTime;


    public void dance(){
        System.out.println("Local time is :" + localDateTime);
        reel.dance();
    }

}
