package com.hexaware.roadready.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CustomerFeedbackDTO;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.repository.FeedBackRepository;

@Service
public class FeedBackServiceImpl implements IFeedBackService {
    
	
	@Autowired
	FeedBackRepository feedbackRepo;
	
	@Override
	public Feedback customerFeedback(CustomerFeedbackDTO feedbackdto) {
		Feedback feedback = new Feedback();		
		feedback.setFeedbackId(feedbackdto.getFeedbackId());
		feedback.setCustomerId(feedbackdto.getCustomerId());
		feedback.setCustomerName(feedbackdto.getCustomerName());
		feedback.setCustomerReview(feedbackdto.getCustomerReview());
		feedback.setRating(feedbackdto.getRating());
		
		return feedbackRepo.save(feedback);
		
		
		
	}

	@Override
	public String adminFeedback(int feedbackId , String adminFeedback) {
		Feedback feedback = feedbackRepo.findById(feedbackId).orElse(null);
		int customerId = feedback.getCustomerId();
		if(feedback!=null) {
			feedback.setAdminFeedback(adminFeedback);
			feedbackRepo.save(feedback);
		}
		return "admin replied to customer " + customerId + " 's  feedback successfully" ;
		
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		return feedbackRepo.findAll();
	}

}
