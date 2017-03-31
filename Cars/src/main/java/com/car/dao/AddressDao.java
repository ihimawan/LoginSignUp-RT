package com.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.car.dto.Address;
import com.car.dto.Dto;
import com.car.dto.Profile;

//testing
public class AddressDao extends DaoTemplate{

	@Override
	void addEntry(Dto dto, Connection conn) {
		
		Address address = (Address) dto;
		
		try {
			PreparedStatement addStatement = conn.prepareStatement("insert into address values(?,?,?)");
			addStatement.setString(1, address.getUser().getUsername());
			addStatement.setString(2, address.getStreet());
			addStatement.setString(3, address.getState());
			
			addStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	String getEntryPassword(String username, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	Dto findEntryById(String username, Connection conn) {
		Address a = null;
		
		try {
			PreparedStatement findStatement = conn.prepareStatement("select address.state, address.street from address join user on user.address_id=address.id where username=?");
			findStatement.setString(1, username);
			
			ResultSet result = findStatement.executeQuery();
			
			while(result.next()){
				a = new Address();
				a.setStreet(result.getString("street"));
				a.setState(result.getString("state"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

}
