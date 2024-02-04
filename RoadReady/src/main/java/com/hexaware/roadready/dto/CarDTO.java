package com.hexaware.roadready.dto;

public class CarDTO {

	private int carId;
	private String make;
	private String model;
	private String carStatus;
	private String location;
	private double dailyRate;
	private String specifications;
	private int passengerCapacity;
	//private String maintenance;
	
	// constructor
	
	public CarDTO() {
		super();
	}

	// parameterized constructor
	
	public CarDTO(int carId, String make, String model, String carStatus, String location, double dailyRate,
			String specifications, int passengerCapacity) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.carStatus = carStatus;
		this.location = location;
		this.dailyRate = dailyRate;
		this.specifications = specifications;
		this.passengerCapacity = passengerCapacity;
	}

	// getter and setters
	
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

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", make=" + make + ", model=" + model + ", carStatus=" + carStatus
				+ ", location=" + location + ", dailyRate=" + dailyRate + ", specifications=" + specifications
				+ ", passengerCapacity=" + passengerCapacity + "]";
	}
	
	
	
	
}
