package com.example.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jdbc.bean.Employee;

@Repository
public class SpringJDBCTestDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Employee> findAllUsingSpringJDBC(){
		
		List<Employee> list = jdbcTemplate.query("Select * from employee",
				new BeanPropertyRowMapper<Employee>(Employee.class));
	
		return list;
		
	}
	
	public Employee findByIdUsingSpringJDBC(int id) {
		
		String query = "select * from employee where id = ?";
		
		@SuppressWarnings("deprecation")
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper<Employee>(Employee.class));
		
		return emp;
		
	}
	
	public int saveDataUsingSpringJDBC(Employee emp) {
		
		String query = "insert into employee(id,firstname,lastname,department,location) values(?,?,?,?,?)";
		
		int status = jdbcTemplate.update(query, new Object[] {emp.getId(),emp.getFirstName(), emp.getLastName(),emp.getDepartment(),emp.getLocation()});
		
		return status;
		
		
	}
	
	public int updateDataUsingSpringJDBC(Employee emp) {
		
		String query = "update employee set firstname=?, lastname=?, department=?, location=? where id=?";
		
		int status = jdbcTemplate.update(query, new Object[] {emp.getFirstName(),emp.getLastName(),emp.getDepartment(),
				emp.getLocation(),emp.getId()});
		return status;
		
	}
	
	public int deleteByIdUsingSpringJDBC(int id) {
		
		String query = "delete from employee where id=?";
		
		int status = jdbcTemplate.update(query, new Object[] {id});
		return status;
		
	}

}
