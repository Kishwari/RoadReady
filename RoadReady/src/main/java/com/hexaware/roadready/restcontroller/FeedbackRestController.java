package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.CustomerFeedbackDTO;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.service.IFeedBackService;

@RestController
@RequestMapping("/roadready/feedbacks")
public class FeedbackRestController {

	@Autowired
	IFeedBackService feedbackService;
	
	   @PostMapping("/CustomerFeedback")
	  public Feedback provideFeedback(@RequestBody CustomerFeedbackDTO feedbackdto) { 		// return type I think feedback ?
		  return feedbackService.customerFeedback(feedbackdto);
	   }
	   @PostMapping("/adminFeedBack/{feedbackId}/{adminFeedback}")
	    public String  giveFeedback(@PathVariable int feedbackId , @PathVariable String adminFeedback) {
	    	return feedbackService.adminFeedback(feedbackId ,adminFeedback);
	    }
	    
	    @GetMapping("/viewAllCustomerFeedBacks")
	    public List<Feedback> viewAllFeedbacks(){
	    	return feedbackService.viewAllFeedbacks();
	    }
	   
}
