package com.example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class JDBCTestDAO {
	@Autowired
	com.example.jdbc.bean.DBConnection dBConnection;
	
	public List<Employee> getAllEmployee(){
		
		Connection con = dBConnection.getConnection();
		List<Employee> list = new ArrayList<>();
		
		try {
			Statement st = con.createStatement();
			
			String query="Select * from employee";
			
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("id"));
				emp.setFirstName(rs.getString("firstname"));
				emp.setLastName(rs.getString("lastname"));
				emp.setDepartment(rs.getString("department"));
				emp.setLocation(rs.getString("location"));
				list.add(emp);
				
			}
			
			con.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public int saveData(Employee emp) {
		
		Connection con = dBConnection.getConnection();
		int status=0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee(id,firstname,lastname,department,location) "
					+ "values(?,?,?,?,?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getDepartment());
			ps.setString(5, emp.getLocation());
			
			status = ps.executeUpdate();
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	public int updateData(Employee emp) {
		Connection con = dBConnection.getConnection();
		int status=0;
		try {
		PreparedStatement ps = 	con.prepareStatement("update employee set firstname=?, lastname=?, department=?, location=? where id=?");
		ps.setString(1, emp.getFirstName());
		ps.setString(2, emp.getLastName());
		ps.setString(3, emp.getDepartment());
		ps.setString(4, emp.getLocation());
		ps.setInt(5, emp.getId());
		
		status = ps.executeUpdate();
		
		con.close();
		ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public int deleteData(int id) {
		Connection con = dBConnection.getConnection();
		int status=0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from employee where id =? ");
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			con.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}


}
