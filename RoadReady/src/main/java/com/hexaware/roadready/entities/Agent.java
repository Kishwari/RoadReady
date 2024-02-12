package com.hexaware.roadready.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Agent {
    
	@Id
	private int agentId;
	@NotBlank
	private String username;
	@NotBlank
	//@Pattern(regexp="^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])[A-Za-z0-9!@#$%^&*()-+=]{10,20}$")
	private String password;
	
	 private String role;
	
	@OneToMany(mappedBy = "agent")
	//@JsonManagedReference
	private List<Customers> customers;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
	
	
	
	public Agent() {
		super();
	}
	
	public Agent(int agentId ,String username, String password , String role) {
		super();
		this.agentId=agentId;
		this.username = username;
		this.password = password;
		this.role=role;
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

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public List<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void   addCustomer(Customers customer) {
		
		customer.setAgent(this);
	    List<Customers>  customerList = getCustomers();
	    customerList.add(customer);

	}
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", username=" + username + ", password=" + password + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
