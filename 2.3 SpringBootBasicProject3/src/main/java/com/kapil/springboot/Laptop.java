package com.kapil.springboot;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

	public void compile() {
		System.out.println("Inside Compile Method of Laptop");
	}

}
