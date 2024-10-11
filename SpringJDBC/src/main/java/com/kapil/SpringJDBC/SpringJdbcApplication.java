package com.kapil.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kapil.SpringJDBC.DAO.KapilDAO;
import com.kapil.SpringJDBC.DAO.RahulDAO;
import com.kapil.SpringJDBC.model.Employee;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Employee kapil = context.getBean(Employee.class);
		kapil.setId(104);
		kapil.setName("Kapil");
		kapil.setTech("Java");
		
		KapilDAO kapilDao = context.getBean(KapilDAO.class);
		kapilDao.save(kapil);		
		System.out.println(kapilDao.findAll());
		
		Employee rahul = context.getBean(Employee.class);
		rahul.setId(113);
		rahul.setName("Rahul");
		rahul.setTech("Java");
		
		RahulDAO rahulaDao = context.getBean(RahulDAO.class);
		rahulaDao.save(rahul);		
		System.out.println(rahulaDao.findAll());
	}

}
