package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.CustomerFeedbackDTO;
import com.hexaware.roadready.entities.Feedback;

public interface IFeedBackService {

	Feedback customerFeedback(CustomerFeedbackDTO feedbackdto);
	
	 public String  adminFeedback(int feedbackId ,String adminFeedback);
	 
	 List<Feedback> viewAllFeedbacks();
}
