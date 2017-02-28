package com.ih.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.hib.dao.CarDao;
import com.car.hib.dto.Car;

@Controller
@RequestMapping(value="/car/*")
public class RestController {
	
	CarDao cd = new CarDao();
	
	@RequestMapping(value="view", method=RequestMethod.GET)
	public @ResponseBody 
	List<Car> getAllCarsJSON(){
		List<Car> list = (List<Car>) cd.read();
		return list;
	}

	@RequestMapping(value="view/{VIN}", method=RequestMethod.GET)
	public @ResponseBody
	Car getCarJSON(@PathVariable("VIN") String VIN){
		Car car = cd.getByVIN(VIN);
		return car;
	}
	
}
