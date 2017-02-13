package com.car.dto;

public class Profile implements Dto{
	
	private User user;
	private String gender;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
