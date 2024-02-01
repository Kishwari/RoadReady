package com.hexaware.roadready.dto;

import java.util.Date;

public class PaymentDTO {

	private int paymentId;
	private double amountPaid;
	private Date dateOfPayment;
	private String modeOfPayment;
	
	// constructor
	
	public PaymentDTO() {
		super();
	}
	
	// parameterized constructor
	public PaymentDTO(int paymentId, double amountPaid, Date dateOfPayment, String modeOfPayment) {
		super();
		this.paymentId = paymentId;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
		this.modeOfPayment = modeOfPayment;
	}
	
	// getters and setters
	
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
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
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
