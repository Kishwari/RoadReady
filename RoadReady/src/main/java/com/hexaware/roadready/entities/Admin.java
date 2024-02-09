package com.hexaware.roadready.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
public class Admin {
    
	@Id
	private int adminId;
	@NotBlank
	private String username;
	@NotBlank
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])[A-Za-z0-9!@#$%^&*()-+=]{10,20}$")
	private String password;
	
	@OneToMany(mappedBy = "admin" , cascade=CascadeType.ALL)
	private Set<Customers> customers = new HashSet<Customers>();
	
	@OneToMany(mappedBy = "admin" , cascade=CascadeType.ALL)
	private Set<Agent> agents = new HashSet<Agent>();
	
	@OneToMany(mappedBy = "admin" , cascade=CascadeType.ALL)
	private Set<Payments> payments = new HashSet<Payments>();
	
	@OneToMany(mappedBy = "admin" , cascade=CascadeType.ALL)
	private Set<Reservations> reservations = new HashSet<Reservations>();
	
	@OneToMany(mappedBy = "admin" , cascade=CascadeType.ALL)
	private Set<Cars> cars = new HashSet<Cars>();

	
	public Admin() {
		super();
	}


	
	public Admin(int adminId , String username, String password) {
		super();
		this.adminId=adminId;
		this.username = username;
		this.password = password;
	}


	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
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

	public Set<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customers> customers) {
		this.customers = customers;
	}

	public Set<Agent> getAgents() {
		return agents;
	}

	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}

	public Set<Payments> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payments> payments) {
		this.payments = payments;
	}

	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}
	
	public Set<Cars> getCars() {
		return cars;
	}

	public void setCars(Set<Cars> cars) {
		this.cars = cars;
	}
	public void   addCustomers(Customers customer) {
		
		customer.setAdmin(this);
	    Set<Customers>  customerSet = getCustomers();
	    customerSet.add(customer);

	}
	public void   addReservations(Reservations reservation) {
		
		reservation.setAdmin(this);
	    Set<Reservations>  reservationSet = getReservations();
	    reservationSet.add(reservation);

	}
	public void   addPayments(Payments payment) {
		
		payment.setAdmin(this);
	    Set<Payments>  paymentSet = getPayments();
	    paymentSet.add(payment);

	}
	public void   addAgents(Agent agent) {
		
		agent.setAdmin(this);
	    Set<Agent>  agentSet = getAgents();
	    agentSet.add(agent);

	}
	public void   addCars(Cars car) {
		
		car.setAdmin(this);
	    Set<Cars>  carSet = getCars();
	    carSet.add(car);

	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ",username=" + username + ", password=" + password + "]";
	}

	
	
	
}
