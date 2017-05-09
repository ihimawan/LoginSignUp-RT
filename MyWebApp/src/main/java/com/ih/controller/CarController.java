package com.ih.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.car.hib.dao.CarDao;
import com.car.hib.dto.Car;

@Controller
public class CarController {
	
	CarDao cd = new CarDao();


	//testing here
	@RequestMapping(value="/test")
	public ModelAndView test(){
		ModelAndView model = new ModelAndView("result");
		model.addObject("success", true);
		model.addObject("message", "this is from test");
		
		return model;
	}

	
	@RequestMapping(value="/add")
	public ModelAndView add(@ModelAttribute("Car") Car car){
		ModelAndView model = new ModelAndView("result");
				
		if (cd.create(car)){
			model.addObject("success", true);
			model.addObject("message", "Car added with VIN = " + car.getVIN());
		}else{
			model.addObject("success", false);
			model.addObject("message", "Adding car with VIN = " + car.getVIN() + " has failed.");
		}
		
		
		return model;
	}
	
	@RequestMapping(value="/delete/{carVIN}")
	public ModelAndView delete(@PathVariable("carVIN") String carVIN){
		ModelAndView model = new ModelAndView("result");
		
		if (cd.delete(carVIN)){
			model.addObject("success", true);
			model.addObject("message", "Car deleted with VIN " + carVIN);
		}else{
			model.addObject("success", false);
			model.addObject("message", "Delete car with VIN " + carVIN + " has failed.");
		}
		
		return model;
		
	}
	
	@RequestMapping(value="/update/{carVIN}")
	public ModelAndView update(@PathVariable("carVIN") String carVIN){
		
		ModelAndView model = new ModelAndView("update");
		Car carInfo = cd.getByVIN(carVIN);
		
		model.addObject("carInfo", carInfo);

		return model;
	}
	
	@RequestMapping(value="/update/execute")
	public ModelAndView updateExecute(@ModelAttribute("Car") Car car){
		
		ModelAndView model = new ModelAndView("result");
		
		System.out.println("CHANGED = " + car.getVIN());
		System.out.println("CHANGED = " + car.getManufacturer());
		
		if(cd.update(car)){
			model.addObject("success", true);
			model.addObject("message", "Car updated with VIN = " + car.getVIN());
		}else{
			model.addObject("success", false);
			model.addObject("message", "Updating car with VIN = " + car.getVIN() + " has failed.");
		}

		return model;
	}
	
}
