package com.car.main;

import java.sql.SQLException;
import java.util.List;

import com.car.hib.dao.CarDao;
import com.car.hib.dao.UserDao;
import com.car.hib.dto.Car;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
//		CarDao cd = new CarDao();
//		
//		Car c1 = new Car("5555","5555", 555, 55.55f, "555");
//		
//		cd.add(c1);
//		
//		cd.viewCars();
//		
//		Car c2 = new Car("5555","66666", 666, 66.66f, "6666");
//		
//		cd.modify(c2);
//		
//		cd.viewCars();
//		
//		cd.deleteByPrimary("5555");
//		
//		cd.viewCars();
//		
//		System.out.println(cd.getCars());
		
		
		UserDao ud = new UserDao();
		
/*
		User u = new User();
	
		u.setUsername("test2");
		u.setPassword("test2");
		
		Address a = new Address();
		a.setState("TX");
		a.setStreet("Main Street");
		a.setUser(u);
		
		Profile p = new Profile();
		p.setGender("Female");
		p.setUser(u);
		
		u.setAddress(a);
		u.setProfile(p);
		
		ud.create(u);

		
		
		System.out.println("PASSWORD IS = " + ud.getEntryPassword("test2"));
		*/
		
		CarDao cd = new CarDao();
		
//		Car car = new Car("9999", "999", 0, 0, "99999");
//
//		cd.create(car);
		
		List<Car> list = cd.read();
		for (Car c: list){
			System.out.println(c.getVIN());
		}
		
		if (list.isEmpty()){
			System.out.println("none available.");
		}
		
//		System.out.println(cd.getByVIN("1112").getModel());
		
	}

}
