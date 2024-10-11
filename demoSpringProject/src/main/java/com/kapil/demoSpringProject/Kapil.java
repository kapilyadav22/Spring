//kapil.java
package com.kapil.demoSpringProject;

public class Kapil {
	
	private int age;
	private Computer computer;
	
	public Kapil(){
		System.out.println("I am inside Kapil Constructor");
	}
	
	public Computer getComputer() {
		return computer;
	}
	
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("Age Assigned");
		this.age = age;
	}
	
	
	public void code() {
		System.out.println("Inside Code Method in Kapil");
		computer.compile();
	}
}
