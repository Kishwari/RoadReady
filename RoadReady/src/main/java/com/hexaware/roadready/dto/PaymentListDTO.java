package com.hexaware.roadready.dto;

import java.time.LocalDate;

public class PaymentListDTO {

	private int paymentId;
	private double amountPaid;
	private LocalDate dateOfPayment;
	private String modeOfPayment;
	private int customerId;
	
	public PaymentListDTO() {
		super();
		
	}
	
	public PaymentListDTO(int paymentId, double amountPaid, LocalDate dateOfPayment, String modeOfPayment,
			int customerId) {
		super();
		this.paymentId = paymentId;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
		this.modeOfPayment = modeOfPayment;
		this.customerId = customerId;
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "PaymentListDTO [paymentId=" + paymentId + ", amountPaid=" + amountPaid + ", dateOfPayment="
				+ dateOfPayment + ", modeOfPayment=" + modeOfPayment + ", customerId=" + customerId + "]";
	}
}
