package com.hexaware.roadready.dto;

import java.time.LocalDate;

public class ReservationListDTO {
	
	private int reservationId;
	private String reservationStatus;
	private LocalDate dateOfReservation;
	private LocalDate dateOfPickup;
	private LocalDate dateOfDropoff;
	private int customerId;
	private int carId;
	private int paymentId;
	public ReservationListDTO() {
		super();

	}
	public ReservationListDTO(int reservationId, String reservationStatus, LocalDate dateOfReservation,
			LocalDate dateOfPickup, LocalDate dateOfDropoff, int customerId, int carId, int paymentId) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.dateOfReservation = dateOfReservation;
		this.dateOfPickup = dateOfPickup;
		this.dateOfDropoff = dateOfDropoff;
		this.customerId = customerId;
		this.carId = carId;
		this.paymentId = paymentId;
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
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "ReservationListDTO [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
				+ ", dateOfReservation=" + dateOfReservation + ", dateOfPickup=" + dateOfPickup + ", dateOfDropoff="
				+ dateOfDropoff + ", customerId=" + customerId + ", carId=" + carId + ", paymentId=" + paymentId + "]";
	}
	
	


}
