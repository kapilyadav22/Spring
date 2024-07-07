package com.kapil.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringProjectApplication {

	public static void main(String[] args) {
		//run is using ConfigurableApplicationContext interface which is extending applicationcontext,
		//so we can store the object in ApplicationContext.
		ApplicationContext context = SpringApplication.run(FirstSpringProjectApplication.class, args);
		
		//we don't want to create the object, so we will call object of class Kapil using springboot
		//getBeans belong to interface ApplicationContext, which gives us particular class
		Kapil k = context.getBean(Kapil.class);
		k.code();
		k.getAge();
	}
 
}
