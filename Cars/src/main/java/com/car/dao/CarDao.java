package com.car.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.car.dto.Car;
import com.car.dto.Dto;

public class CarDao extends DaoTemplate{

	public void viewCars() throws ClassNotFoundException{
		Connection conn = null;
		
		try {
			
			System.out.println("---------------------------------");
			System.out.println("       V I E W    T A B L E      ");
			System.out.println("---------------------------------");
			
			conn = getConnection();
			
			PreparedStatement stmt = conn.prepareStatement("select * from car");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				System.out.print(rs.getString("VIN") + " ");
				System.out.print(rs.getString("model") + " ");
				System.out.print(rs.getFloat("price") + " ");
				System.out.print(rs.getInt("year"));
				System.out.println();
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	void addEntry(Dto dto, Connection conn) {
		Car car = (Car) dto;
		
		try {
			
			PreparedStatement addStatement = conn.prepareStatement("insert into car values(?,?,?,?,?,?)");
			addStatement.setString(1, car.getVIN());
			addStatement.setString(2, car.getModel());
			addStatement.setInt(3, car.getYear());
			addStatement.setFloat(4, car.getPrice());
			addStatement.setString(5, car.getColor());
			addStatement.setString(6, "manufacturerDummy");
			
			addStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteByPrimary(String VIN) throws ClassNotFoundException{
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			PreparedStatement addStatement = conn.prepareStatement("delete from car where VIN = ?");
			addStatement.setString(1, VIN);
			
			addStatement.executeUpdate();
			
			System.out.println("");
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void modify(Car car) throws ClassNotFoundException{
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			PreparedStatement addStatement = conn.prepareStatement("update car set model=?, year=?, price=?, color=? where VIN=?");
			
			addStatement.setString(1, car.getModel());
			addStatement.setInt(2, car.getYear());
			addStatement.setFloat(3, car.getPrice());
			addStatement.setString(4, car.getColor());
			addStatement.setString(5, car.getVIN());
			
			addStatement.executeUpdate();
			
			System.out.println("");
			
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Car> getCars() throws ClassNotFoundException{
		
		Connection conn= null;
		
		HashMap<String, Car> result = new HashMap<String, Car>();
		
		try {
			conn = getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select * from car order by model");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String key = rs.getString("VIN");
				Car value = new Car(key, rs.getString("model"), rs.getInt("year"), rs.getFloat("price"), rs.getString("color"));
				
				System.out.println(rs.getString("model"));
				
				result.put(key, value);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public HashMap<String, Car> getCarsFilterByModel(String model) throws ClassNotFoundException{
		
		Connection conn= null;
		
		HashMap<String, Car> result = new HashMap<String, Car>();
		
		try {
			conn = getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select * from car where model = ?");
			ps.setString(1, model);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String key = rs.getString("VIN");
				Car value = new Car(key, rs.getString("model"), rs.getInt("year"), rs.getFloat("price"), rs.getString("color"));
				
				result.put(key, value);
			}
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
		
	}



	@Override
	String getEntryPassword(String username, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Dto findEntryById(String id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}



	
}

