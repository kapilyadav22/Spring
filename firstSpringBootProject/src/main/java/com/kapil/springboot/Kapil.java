package com.kapil.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Kapil {
	
	//the moment we load the application, it will give us two objects, object of Laptop, object of Kapil
	//it will manage by springboot
	
	@Value("25")
	int age;
	
	public int getAge() {
		System.out.println(age);
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	//default autowire behaviour is by type, so if you write Computer desktop, it will wired to desktop
	@Autowired
	@Qualifier("laptop") //uses laptop as primary bean, even we mark desktop using primary annotation
	Computer com;
	
	public void code() {
		com.compile();
	}
}
