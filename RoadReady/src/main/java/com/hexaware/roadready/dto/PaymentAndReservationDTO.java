package com.hexaware.roadready.dto;

import java.time.LocalDate;

public class PaymentAndReservationDTO {
    
	private int customerId;
	private int carId;
	private int paymentId;
	private double amountPaid;
	private String modeOfPayment;
	private int resevationId;
	private LocalDate dateOfPickup;
	private LocalDate dateOfDropOff;
	
	
	public PaymentAndReservationDTO() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentAndReservationDTO(int paymentId, double amountPaid, String modeOfPayment,
			int customerId, int carId, int resevationId, LocalDate dateOfPickup, LocalDate dateOfDropOff) {
		super();
		this.paymentId = paymentId;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.customerId = customerId;
		this.carId = carId;
		this.resevationId = resevationId;
		this.dateOfPickup = dateOfPickup;
		this.dateOfDropOff = dateOfDropOff;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	public int getResevationId() {
		return resevationId;
	}
	public void setResevationId(int resevationId) {
		this.resevationId = resevationId;
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
