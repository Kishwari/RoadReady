package com.hexaware.roadready.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
    @SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_seq", initialValue = 4001)
	private int feedbackId;
	@NotNull
	private int customerId;
	@NotBlank
	private String customerName;
	@NotBlank
	private String customerReview;
	@NotNull
	@Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
	private int rating;
	
	private String AdminFeedback;
	
	public Feedback() {
		super();

	}

	public Feedback(int feedbackId, int customerId,  String customerName,
			String customerReview, int rating, String adminFeedback) {
		super();
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerReview = customerReview;
		this.rating = rating;
		this.AdminFeedback = adminFeedback;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
		this.AdminFeedback = adminFeedback;
	}

	
}
