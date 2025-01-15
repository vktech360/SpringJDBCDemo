package com.example.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.bean.Employee;
import com.example.jdbc.dao.SpringJDBCTestDAO;

@RestController
public class SpringJDBCTestController {
	@Autowired
	SpringJDBCTestDAO springJDBCTestDAO;
	
	@GetMapping("/getAllDataUsingSpringJDBC")
	public ResponseEntity<List<Employee>> getAllDataUsingSpringJDBC(){
		
		List<Employee> list = springJDBCTestDAO.findAllUsingSpringJDBC();
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/findByIdUsingSpringJDBC")
	public ResponseEntity<Employee> findByIdUsingSpringJDBC(@RequestParam int id){
		
		Employee emp = springJDBCTestDAO.findByIdUsingSpringJDBC(id);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	@PostMapping("/saveDataUsingSpringJDBC")
	public ResponseEntity<String> saveDataUsingSpringJDBC(@RequestBody Employee emp){
		
		int status = springJDBCTestDAO.saveDataUsingSpringJDBC(emp);
		
		return new ResponseEntity<String>(status > 0 ? "Record saved":"Record not saved",HttpStatus.OK);
		
	}
	
	@PostMapping("updateDataUsingSpringJDBC")
	public ResponseEntity<String> updateDataUsingSpringJDBC(@RequestBody Employee emp){
		
		int status = springJDBCTestDAO.updateDataUsingSpringJDBC(emp);
		
		return new ResponseEntity<String>(status > 0? "Record updated":"Record not updated",HttpStatus.OK);
		
	}
	
	@GetMapping("deleteByIdUsingSpringJDBC")
	public ResponseEntity<String> deleteByIdUsingSpringJDBC(@RequestParam int id){
		
		int status = springJDBCTestDAO.deleteByIdUsingSpringJDBC(id);
		
		return new ResponseEntity<String>(status > 0 ? "Record deleted":"Record not deleted",HttpStatus.OK);
		
	}

}
