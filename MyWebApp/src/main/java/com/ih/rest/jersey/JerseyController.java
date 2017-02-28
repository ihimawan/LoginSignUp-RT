package com.ih.rest.jersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.car.hib.dao.CarDao;
import com.car.hib.dto.Car;

@Path("/car")
public class JerseyController {
	
	CarDao cd = new CarDao();
	
	@Path("/model/{model}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getModelCarsJSON(@PathParam("model") String model){
		
		List<Car> list = null;
		
		
		if (model.equals("null")){
			list = cd.read();
		}else{
			list = cd.getCarsFilterByModel(model);
		}
		
		//Unecessary
//		GenericEntity<List<Car>> entity = new GenericEntity<List<Car>>(list) {};
//		Response response = Response.ok(entity).build();
		
		return list;
	}
	
	@Path("/vin/{VIN}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCarJSON(@PathParam("VIN") String VIN){
		Car car = cd.getByVIN(VIN);
		return car;
	}
}
