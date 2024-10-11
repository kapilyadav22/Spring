package com.kapil.SpringJDBC.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.kapil.SpringJDBC.model.Employee;


@Repository
public class RahulDAO {
	
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Employee kapil) {
		String sqlString = "insert into rahul (id,name, tech) values (?,?,?)";
		int rows = template.update(sqlString,kapil.getId(),kapil.getName(),kapil.getTech());	
		System.out.println(rows + " rows/ affected");
		//		System.out.println("Added");
	}
	
	public List<Employee> findAll(){
		String sqlString = "select * from rahul";
		
		
		RowMapper<Employee> mapper = new RowMapper<Employee>() {
			
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee kapil = new Employee();
				kapil.setId(rs.getInt(1));
				kapil.setName(rs.getString(2));
				kapil.setTech(rs.getString(3));	
				return kapil;
			}
		};
	
		List<Employee> data= template.query(sqlString,mapper);
		return  data;
	}

}
