package com.example.jdbc.bean;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {
	
	@Value("${spring.datasource.driverClassName}")
	String dClass;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	
	Connection con=null;
	public Connection getConnection() {
		try {
			Class.forName(dClass);
			 con = DriverManager.getConnection(url, username, password);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("con= "+con);
		return con;
		
	}
	

}
