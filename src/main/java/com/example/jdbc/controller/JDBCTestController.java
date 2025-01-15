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

@RestController
public class JDBCTestController {
	@Autowired
	com.example.jdbc.dao.JDBCTestDAO jDBCTestDAO;
	
	@GetMapping("getAllData")
	public ResponseEntity<List<Employee>> getAllData(){
		
		List<Employee> list = jDBCTestDAO.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping("saveData")
	public ResponseEntity<String> saveData(@RequestBody Employee emp){
		int status = jDBCTestDAO.saveData(emp);
		
		return new ResponseEntity<String>(status >0 ? "Record saved":"Record not saved",HttpStatus.OK);
		
	}
	@PostMapping("updateData")
	public ResponseEntity<String> updateData(@RequestBody Employee emp){
		
		int status = jDBCTestDAO.updateData(emp);
		
		return new ResponseEntity<String>(status >0 ? "Record Updated":"Record not updated",HttpStatus.OK);
		
	}
	
	@GetMapping("/deleteData")
	public ResponseEntity<String> deleteData(@RequestParam int id){
		
		int status = jDBCTestDAO.deleteData(id);
		
		return new ResponseEntity<String>(status >0 ? "Record deleted":"Record not deleted",HttpStatus.OK);
		
	}

}
