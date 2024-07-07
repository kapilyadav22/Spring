package com.kapil.demoSpringProject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {	//Spring Provides the Dependency Inversion / IOC (Inversion of Control) 
    	
    	//ClassPathXmlApplicationContext will check sprin.xml in main->resources
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	
    	//if we comment the next lines still the constructor of kapil class will be call, it's because 
    	//first main will call, it will check, and it will create ApplicationContext object.
    	//ApplicationContext will create spring container.
    	//All the processes we do in java, happens inside JVM, inside JVM, it will have container, which will have spring beans,
    	//It will create all the objects of classes, whose entry is in spring.xml
    	Kapil obj =  (Kapil) context.getBean("kapil");   	
//    	obj.setAge(26);
    	System.out.println(obj.getAge());
    	obj.code();    	
    	//spring beans are singleton beans
    }
}
