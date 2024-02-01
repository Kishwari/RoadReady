package com.hexaware.roadready.dto;


public class AdminDTO {

	private String username;
	private String password;
	
	
	public AdminDTO() {
		super();
	}

	// parameterized constructor
	
	public AdminDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	// setter and getters
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
