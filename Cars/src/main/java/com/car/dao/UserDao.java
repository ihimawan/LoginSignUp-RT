package com.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.dto.Dto;
import com.car.dto.User;

public class UserDao extends DaoTemplate{

	DaoTemplate addressDao = new AddressDao();
	DaoTemplate profileDao = new ProfileDao();
	
	@Override
	void addEntry(Dto dto, Connection conn) {
		
		User user = (User) dto;
		
		try {
			
			PreparedStatement addStatement = conn.prepareStatement("insert into user values(?,?)");
			addStatement.setString(1, user.getUsername());
			addStatement.setString(2, user.getPassword());
	
			addressDao.addEntry(user.getAddress(), conn);
			profileDao.addEntry(user.getProfile(), conn);
			
			addStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	Dto findEntryById(String username, Connection conn) {
		
		ResultSet result = null;
		
		User u = null;
		
		try {
			PreparedStatement findStatement = conn.prepareStatement("select * from user where username=?");
			findStatement.setString(1, username);
			result = findStatement.executeQuery();

			while(result.next()){
				u = new User();
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("password"));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;

	}

	@Override
	String getEntryPassword(String username, Connection conn) {
		User result = (User)findEntryById(username, conn);
		
			if (result != null){
				System.out.println("pass = " + result.getPassword());
				return result.getPassword();
			}else{
				return null;
			}
		
	}
	
	

}
