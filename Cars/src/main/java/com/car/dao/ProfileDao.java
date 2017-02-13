package com.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.car.dto.Dto;
import com.car.dto.Profile;
import com.car.dto.User;

public class ProfileDao extends DaoTemplate{

	@Override
	void addEntry(Dto dto, Connection conn) {
		Profile profile = (Profile) dto;
		
		try {
			PreparedStatement addStatement = conn.prepareStatement("insert into profile values(?,?)");
			addStatement.setString(1, profile.getUser().getUsername());
			addStatement.setString(2, profile.getGender());
			
			addStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	Dto findEntryById(String username, Connection conn) {
		
		Profile p = null;
		
		try {
			PreparedStatement findStatement = conn.prepareStatement("select profile.gender from profile join user on user.profile_id=profile.id where username=?");
			findStatement.setString(1, username);
			
			ResultSet result = findStatement.executeQuery();
			
			while(result.next()){
				p = new Profile();
				p.setGender(result.getString("gender"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	String getEntryPassword(String username, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
