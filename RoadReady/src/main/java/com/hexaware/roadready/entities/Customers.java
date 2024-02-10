package com.hexaware.roadready.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity

public class Customers{
 
	        @Id
			private int customerId;
	        @NotBlank
			private String firstName;
	        @NotBlank
			private String lastName;
	        @NotBlank
	        @Pattern(regexp="^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])[A-Za-z0-9!@#$%^&*()-+=]{10,20}$")
			private String username;
	        @Pattern(regexp= "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
			private String emailAddress;
	        @NotBlank
			private String password;
	        @NotBlank
	        @Pattern(regexp="\\d{10}")
			private String phoneNumber;
	        
	        private String role;
			
			@OneToMany(mappedBy = "customer" , cascade=CascadeType.ALL)
			private Set<Payments> payments = new HashSet<Payments>();
			
			@OneToMany(mappedBy = "customer" , cascade=CascadeType.ALL)
			private Set<Reservations> reservations = new HashSet<Reservations>();
			
			@ManyToOne
			@JoinColumn(name = "adminId")
			private Admin admin;
			
			@ManyToOne
			@JoinColumn(name = "agentId")
			//@JsonIgnore
			//@JsonBackReference
			private Agent agent;
			
			public Customers() {
				super();
				
			}
			public Customers(int customerId, String firstName, String lastName, String emailAddress,String username, String password,
					String phoneNumber , String role) {
				super();
				this.customerId = customerId;
				this.firstName = firstName;
				this.lastName = lastName;
				this.username=username;
				this.emailAddress = emailAddress;
				this.password = password;
				this.phoneNumber = phoneNumber;
				this.role = "ROLE_CUSTOMER";
			}
			public int getCustomerId() {
				return customerId;
			}
			public void setCustomerId(int customerId) {
				this.customerId = customerId;
			}
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getEmailAddress() {
				return emailAddress;
			}
			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getPhoneNumber() {
				return phoneNumber;
			}
			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}
			
			
			public Set<Payments> getPayments() {
				return payments;
			}
			public void setPayments(Set<Payments> payments) {
				this.payments = payments;
			}
			
			public void   addPayment(Payments payment) {
				
				payment.setCustomer(this);
			    Set<Payments>  paymentSet = getPayments();
			    paymentSet.add(payment);
	
			}
			
			public Set<Reservations> getReservations() {
				return reservations;
			}
			public void setReservations(Set<Reservations> reservations) {
				this.reservations = reservations;
			}
			
            public void   addReservations(Reservations reservation) {
				
				reservation.setCustomer(this);
			    Set<Reservations>  reservationSet = getReservations();
			    reservationSet.add(reservation);
	
			}
            
            public Admin getAdmin() {
				return admin;
			}
			public void setAdmin(Admin admin) {
				this.admin = admin;
			}
			
			//@JsonIgnore 
			public Agent getAgent() {
				return agent;
			}
			public void setAgent(Agent agent) {
				this.agent = agent;
			}
            
			@Override
			public String toString() {
				return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
						+ ", username=" + username + ", emailAddress=" + emailAddress + ", password=" + password
						+ ", phoneNumber=" + phoneNumber + "]";
			}
			public String getRole() {
				return role;
			}
			public void setRole(String role) {
				this.role = role;
			}
			
			
}		
			
