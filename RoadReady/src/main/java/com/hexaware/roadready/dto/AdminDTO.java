package com.hexaware.roadready.dto;


public class AdminDTO {
    
	private String adminId;
	private String username;
	private String password;
	
	public AdminDTO() {
		super();
		
	}
	public AdminDTO(String adminId, String username, String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
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
		return "AdminDTO [adminId=" + adminId + ", username=" + username + ", password=" + password + "]";
	}
	
	
}