package com.hexaware.roadready.dto;


public class CustomerFeedbackDTO {

	private int feedbackId;
	private int customerId;
	private String customerName;
	private String customerReview;
	private int rating;
	
	public CustomerFeedbackDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerFeedbackDTO(int feedbackId, int customerId, String customerName, String customerReview, int rating) {
		super();
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerReview = customerReview;
		this.rating = rating;
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
	@Override
	public String toString() {
		return "CustomerFeedbackDTO [FeedbackId=" + feedbackId + ", customerId=" + customerId + ", customerName="
				+ customerName + ", customerReview=" + customerReview + ", rating=" + rating + "]";
	}
	
	
}
