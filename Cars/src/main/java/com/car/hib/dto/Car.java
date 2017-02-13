package com.car.hib.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.car.dto.Dto;

@Entity
@Table(name="car")
public class Car implements Dto{
	
	@Id
	private String VIN;
	
	private String model;
	private int year;
	private float price;
	private String color;
	

	public Car() {

	}
	
	public Car(String vIN, String model, int year, float price, String color) {
		super();
		VIN = vIN;
		this.model = model;
		this.year = year;
		this.price = price;
		this.color = color;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}

