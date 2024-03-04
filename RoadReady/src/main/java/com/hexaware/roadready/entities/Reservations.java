package com.hexaware.roadready.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

@Entity
public class Reservations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resevation_seq")
    @SequenceGenerator(name = "resevation_seq", sequenceName = "resevation_seq", initialValue = 3001)
	private int resevationId;    
	private String reservationStatus ; 
	@NotNull(message="cannot be blank")
	private LocalDate dateOfReservation;
	@NotNull(message="cannot be blank")
	private LocalDate dateOfPickup;
	@NotNull(message="cannot be blank")
	private LocalDate dateOfDropoff;
	
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
	public Reservations(int resevationId, String reservationStatus, LocalDate dateOfReservation,
			LocalDate dateOfPickup, LocalDate dateOfDropoff) {
		super();
		this.resevationId = resevationId;
		this.reservationStatus = reservationStatus;
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
	
	public String getReservationstatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public LocalDate getDateOfReservation() {
		return dateOfReservation;
	}
	public void setDateOfReservation(LocalDate dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}
	public LocalDate getDateOfPickup() {
		return dateOfPickup;
	}
	public void setDateOfPickup(LocalDate dateOfPickup) {
		this.dateOfPickup = dateOfPickup;
	}
	public LocalDate getDateOfDropoff() {
		return dateOfDropoff;
	}
	public void setDateOfDropoff(LocalDate dateOfDropoff) {
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
				 ", reservationStatus=" + reservationStatus + ", dateOfReservation=" + dateOfReservation
				+ ", dateOfPickup=" + dateOfPickup + ", dateOfDropoff=" + dateOfDropoff + "]";
	}
	
    
	
}
