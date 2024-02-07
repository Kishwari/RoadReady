package com.hexaware.roadready.service;

import com.hexaware.roadready.entities.Feedback;

public interface IFeedBackService {

	Feedback provideFeedback(Feedback feedback);
	
	 public String  giveFeedback(String adminFeedback);
}
