package com.car.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.car.dto.Car;
import com.car.dto.Dto;

public abstract class DaoTemplate {
	protected Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automaker", "root", "123123");
		return conn;
	}
	
	public void add(Dto dto) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		
		addEntry(dto, conn);
		
		conn.commit();
		conn.close();
	}
	
	public Dto findById(String username) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		
		Dto result= findEntryById(username, conn);
		
		conn.commit();
		conn.close();
		
		return result;
	}
	
	public String getPassword(String username) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		
		String password = getEntryPassword(username, conn);
		
		conn.commit();
		conn.close();
		
		return password;
	}
	
	abstract Dto findEntryById(String id, Connection conn);
	abstract void addEntry(Dto dto, Connection conn);
	abstract String getEntryPassword(String username, Connection conn);
}
