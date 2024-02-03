package com.hexaware.roadready.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Reservations {
	
	@Id
	private int resevationId;    
	@NotBlank
	private String Reservationstatus ; 
	@NotBlank
	private Date dateOfReservation;
	@NotBlank
	private Date dateOfPickup;
	@NotBlank
	private Date dateOfDropoff;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customers customer;
	
	@ManyToOne
	@JoinColumn(name = "carId")
	private Cars car;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="paymentId")
	private Payments payment;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
	
	public Reservations() {
		super();
	
	}
	public Reservations(int resevationId, int carId, int customerId, String reservationstatus, Date dateOfReservation,
			Date dateOfPickup, Date dateOfDropoff) {
		super();
		this.resevationId = resevationId;
		//this.carId = carId;
		//this.customerId = customerId;
		this.Reservationstatus = reservationstatus;
		this.dateOfReservation = dateOfReservation;
		this.dateOfPickup = dateOfPickup;
		this.dateOfDropoff = dateOfDropoff;
	}
	public int getResevationId() {
		return resevationId;
	}
	public void setResevationId(int resevationId) {
		this.resevationId = resevationId;
	}
	//public int getCarId() {
		//return carId;
	//}
	//public void setCarId(int carId) {
	//	this.carId = carId;
	//}
	//public int getCustomerId() {
		//return customerId;
	//}
	//public void setCustomerId(int customerId) {
		//this.customerId = customerId;
	//}
	public String getReservationstatus() {
		return Reservationstatus;
	}
	public void setReservationstatus(String reservationstatus) {
		Reservationstatus = reservationstatus;
	}
	public Date getDateOfReservation() {
		return dateOfReservation;
	}
	public void setDateOfReservation(Date dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}
	public Date getDateOfPickup() {
		return dateOfPickup;
	}
	public void setDateOfPickup(Date dateOfPickup) {
		this.dateOfPickup = dateOfPickup;
	}
	public Date getDateOfDropoff() {
		return dateOfDropoff;
	}
	public void setDateOfDropoff(Date dateOfDropoff) {
		this.dateOfDropoff = dateOfDropoff;
	}
	
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Cars getCar() {
		return car;
	}
	public void setCar(Cars car) {
		this.car = car;
	}
	public Payments getPayment() {
		return payment;
	}
	public void setPayment(Payments payment) {
		this.payment = payment;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "Reservation [resevationId=" + resevationId + 
				 ", Reservationstatus=" + Reservationstatus + ", dateOfReservation=" + dateOfReservation
				+ ", dateOfPickup=" + dateOfPickup + ", dateOfDropoff=" + dateOfDropoff + "]";
	}
	
    
	
}
