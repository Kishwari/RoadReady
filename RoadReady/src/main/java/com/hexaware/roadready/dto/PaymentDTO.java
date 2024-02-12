package com.hexaware.roadready.dto;

import java.time.LocalDate;

public class PaymentDTO {

	private int paymentId;
	private double amountPaid;
	private LocalDate dateOfPayment;
	private String modeOfPayment;
	
	
	public PaymentDTO() {
		super();
	}
	

	public PaymentDTO(int paymentId, double amountPaid, LocalDate dateOfPayment, String modeOfPayment) {
		super();
		this.paymentId = paymentId;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
		this.modeOfPayment = modeOfPayment;
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
	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", amountPaid=" + amountPaid + ", dateOfPayment=" + dateOfPayment
				+ ", modeOfPayment=" + modeOfPayment + "]";
	}
	
	
}
