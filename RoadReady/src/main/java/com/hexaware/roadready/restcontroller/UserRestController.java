package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.AuthRequest;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.service.AdminServiceImpl;
import com.hexaware.roadready.service.AgentServiceImpl;
import com.hexaware.roadready.service.CustomerServiceImpl;
import com.hexaware.roadready.service.JwtService;
import com.hexaware.roadready.service.UserService;



@RestController
@RequestMapping("/registration")
public class UserRestController {

	

		@Autowired
		UserService userService;
		
		@Autowired
		AuthenticationManager authenticationManager;
		
		@Autowired
		JwtService jwtService;
	
		@PostMapping("/customer/new")
	    public String addNewCustomer(@RequestBody Customers customer) {
	        return userService.addCustomer(customer);
	    }
		

	   @PostMapping("/agent/new")
	    public String addNewAgent(@RequestBody Agent agent) {
	        return userService.addAgent(agent);
	    }
 

	   @PostMapping("/admin/new")
	    public String addNewAdmin(@RequestBody Admin admin) {
	        return userService.addAdmin(admin); 
	    }
		 
		 
		

	 
     @PostMapping("/authenticate")  
	 public String authenticateAndGetToken(@RequestBody AuthRequest authRequest ) {
		 //we are not adding into database so no need to save to db
    	 //we create dto to just get password and username
     Authentication authentication =  	 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
    	 
     String token = null;
  
     if(authentication.isAuthenticated()) {
	  //call generate token method from jwt class(we need to create this class with pre defined methods)
        token =   jwtService.generateToken(authRequest.getUsername());
     }
     else {
	  throw  new UsernameNotFoundException(" invalid  request ");
     }
	  
	return token; 
     
     }
     
     
}
