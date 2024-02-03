package com.hexaware.roadready.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Feedback {
	@NotBlank
	private int customerId;
	@NotBlank
	private String customerName;
	@NotBlank
	private String customerReview;
	@NotBlank
	@Pattern(regexp="[1-5")
	private int rating;
	private String AdminFeedback;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Feedback(int customerId, String customerName, String customerReview, int rating, String adminFeedback) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerReview = customerReview;
		this.rating = rating;
		AdminFeedback = adminFeedback;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerReview() {
		return customerReview;
	}
	public void setCustomerReview(String customerReview) {
		this.customerReview = customerReview;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getAdminFeedback() {
		return AdminFeedback;
	}
	public void setAdminFeedback(String adminFeedback) {
		AdminFeedback = adminFeedback;
	}
}
