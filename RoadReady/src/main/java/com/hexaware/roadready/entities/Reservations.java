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





@Entity
public class Reservations {

	@Id
	private int reservationId;
	private String reservationStatus;
	private Date dateOfReservation;
	private Date dateOfPickup;
	private  Date dateOfDropoff;
	
	// for reservations to customers (1-M)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customers customers;
	
	//for reservations to payment (1-1)
	@OneToOne(mappedBy="reservations")
	private Payments payment;
	
	// for reservations to car (1-M)
	@OneToMany(mappedBy="reservations")
	//@JoinColumn(name="car_id")
	private Set<Cars> carSet=new HashSet<Cars>();
	
	public Reservations() {
		super();
	}


	public Reservations(int reservationId, String reservationStatus, Date dateOfReservation,
			Date dateOfPickup, Date dateOfDropoff , Set<Cars> carSet) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.dateOfReservation = dateOfReservation;
		this.dateOfPickup = dateOfPickup;
		this.dateOfDropoff = dateOfDropoff;
		this.carSet=carSet;
	}


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}


	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
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

	
	// for one to many
	
	public Set<Cars> getCarSet() {
		return carSet;
	}

	public void setCarSet(Set<Cars> carSet) {
		this.carSet = carSet;
	}

	public void addCar(Cars car) {
		// this.employeeSet.add(emp);
		Set<Cars> set=getCarSet();
		set.add(car);
	}

	@Override
	public String toString() {
		return "Reservations [reservationId=" + reservationId + ", reservationStatus="
				+ reservationStatus + ", dateOfReservation=" + dateOfReservation + ", dateOfPickup=" + dateOfPickup
				+ ", dateOfDropoff=" + dateOfDropoff + "]";
	}
	
	
}
