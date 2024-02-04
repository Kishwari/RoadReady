package com.hexaware.roadready.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cars {
	@Id
	private int carId;
	@NotBlank
	private String make;
	@NotBlank
	private String model;
	@NotBlank
	private String location;
	@NotBlank
	private double dailyRate;
	@NotBlank
	private String carStatus;
	@NotBlank
	private String specification;
	@NotBlank
	private int passengerCapacity;
	//private String maintenance;
	
	@OneToMany(mappedBy = "car" , cascade=CascadeType.ALL)
	private Set<Reservations> reservations = new HashSet<Reservations>();
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
	
	
	public Cars() {
		super();
		
	}
	public Cars(int carId, String make, String model,  String location, double dailyRate,
			String carStatus, String specification, int passengerCapacity) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		//this.numberOfCarsAvailable = numberOfCarsAvailable;
		this.location = location;
		this.dailyRate = dailyRate;
		this.carStatus = carStatus;
		this.specification = specification;
		this.passengerCapacity = passengerCapacity;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	//public int getNumberOfCarsAvailable() {
	//	return numberOfCarsAvailable;
	//}
	//public void setNumberOfCarsAvailable(int numberOfCarsAvailable) {
	//	this.numberOfCarsAvailable = numberOfCarsAvailable;
//	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	
	
	public Set<Reservations> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void  addReservations(Reservations reservation) {
		
		reservation.setCar(this);
	    Set<Reservations>  reservationSet = getReservations();
	    reservationSet.add(reservation);

	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", make=" + make + ", model=" + model +  ", location=" + location + ", dailyRate=" + dailyRate + ", carStatus="
				+ carStatus + ", specification=" + specification + ", passengerCapacity=" + passengerCapacity + "]";
	}
	
	
}
