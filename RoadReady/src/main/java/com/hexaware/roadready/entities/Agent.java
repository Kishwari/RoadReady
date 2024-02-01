package com.hexaware.roadready.entities;

import jakarta.persistence.Entity;

@Entity
public class Agent {
    
	private String username;
	private String password;
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agent(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
		return "Agent [username=" + username + ", password=" + password + "]";
	}
}
