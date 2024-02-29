package com.hexaware.roadready.dto;

import java.time.LocalDate;

public class PaymentAndReservationDTO {
    
	private int customerId;
	private int carId;
	private double amountPaid;
	private String modeOfPayment;
	private LocalDate dateOfPickup;
	private LocalDate dateOfDropOff;
	
	
	public PaymentAndReservationDTO() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentAndReservationDTO(double amountPaid, String modeOfPayment,
			int customerId, int carId,  LocalDate dateOfPickup, LocalDate dateOfDropOff) {
		super();
	
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.customerId = customerId;
		this.carId = carId;
	
		this.dateOfPickup = dateOfPickup;
		this.dateOfDropOff = dateOfDropOff;
	}
	
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public LocalDate getDateOfPickup() {
		return dateOfPickup;
	}
	public void setDateOfPickup(LocalDate dateOfPickup) {
		this.dateOfPickup = dateOfPickup;
	}
	public LocalDate getDateOfDropOff() {
		return dateOfDropOff;
	}
	public void setDateOfDropOff(LocalDate dateOfDropOff) {
		this.dateOfDropOff = dateOfDropOff;
	}
}
