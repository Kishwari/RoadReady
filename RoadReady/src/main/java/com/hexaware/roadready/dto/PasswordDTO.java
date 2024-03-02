package com.hexaware.roadready.dto;

public class PasswordDTO {

	private int id;
	private String username;
	private String newPassword;
	
	public PasswordDTO() {
		super();
	}


	public PasswordDTO(int id, String username,String newPassword) {
		super();
		this.id = id;
		this.username = username;
		this.newPassword= newPassword;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
}
