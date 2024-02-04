package com.hexaware.roadready.dto;


public class FeedbackDTO {

	private int FeedbackId;
	private int customerId;
	private String customerName;
	private String customerReview;
	private int rating;
	private String AdminFeedback;
	public FeedbackDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedbackDTO(int feedbackId, int customerId, String customerName, String customerReview, int rating,
			String adminFeedback) {
		super();
		FeedbackId = feedbackId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerReview = customerReview;
		this.rating = rating;
		AdminFeedback = adminFeedback;
	}
	public int getFeedbackId() {
		return FeedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		FeedbackId = feedbackId;
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
	@Override
	public String toString() {
		return "FeedbackDTO [FeedbackId=" + FeedbackId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerReview=" + customerReview + ", rating=" + rating + ", AdminFeedback=" + AdminFeedback
				+ "]";
	}
}
