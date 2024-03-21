package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.ProfilePicture;
import com.hexaware.roadready.repository.AdminRepository;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.repository.ProfilePictureRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/roadready/profilePicture")
public class ProfilePictureRestController {
	
	@Autowired
	ProfilePictureRepository profileRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	AgentRepository agentRepo;
	
	@PostMapping("/uploadUserPicture/{userId}")
	@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER','ROLE_AGENT','ROLE_ADMIN')")
	public String uploadImageFile(@RequestParam("file") MultipartFile file, @PathVariable int userId) {
	   try {
	     ProfilePicture imageFile = new ProfilePicture();
	      Customers customer = customerRepo.findById(userId).orElse(null);
	      Admin admin=adminRepo.findById(userId).orElse(null);
	      Agent agent=agentRepo.findById(userId).orElse(null);
	      
	       if (customer != null) {
	            imageFile.setUserId(userId);
	            imageFile.setRole("ROLE_CUSTOMER");
	            imageFile.setContent(file.getBytes()); // Save the image file content
	            profileRepo.save(imageFile);
	            return "Image uploaded successfully!";
	        }
	       
	       else if (agent != null) {
	            imageFile.setUserId(userId);
	            imageFile.setRole("ROLE_AGENT");
	            imageFile.setContent(file.getBytes()); // Save the image file content
	            profileRepo.save(imageFile);
	            return "Image uploaded successfully!";
	        }
	       
	       else if (admin != null) {
	            imageFile.setUserId(userId);
	            imageFile.setRole("ROLE_ADMIN");
	            imageFile.setContent(file.getBytes()); // Save the image file content
	            profileRepo.save(imageFile);
	            return "Image uploaded successfully!";
	        }
	       
	   
	       else {
	    	   return "image upload failed";
	       }
	       
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   return "Failed to upload image: " + e.getMessage();
	   }
	}
	
	


}