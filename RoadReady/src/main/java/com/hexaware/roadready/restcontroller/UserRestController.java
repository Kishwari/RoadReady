package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.AuthRequest;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.service.AgentServiceImpl;
import com.hexaware.roadready.service.CustomerServiceImpl;
import com.hexaware.roadready.service.JwtService;
//import com.hexaware.roadready.service.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/roadready/user")
public class UserRestController {

	
	
	     @Autowired
	     CustomerServiceImpl customerService;
	     
	     @Autowired
	     AgentServiceImpl agentService;
		
		@Autowired
		AuthenticationManager authenticationManager;
		
		@Autowired
		JwtService jwtService;
		
		@GetMapping("/welcome")
		public String welcome() {
			return "WELCOME TO ROAD READY";
		}
	
		@PostMapping("/createNewCustomerAccount")
	    public Customers	addCustomer(@Valid @RequestBody CustomerDTO customer) {
			return customerService.addCustomer(customer);
		}
		
		 
		

	 
     @PostMapping("/authenticate")  
	 public String authenticateAndGetToken(@RequestBody AuthRequest authRequest ) {
     Authentication authentication =  	 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
    	 
     String token = null;
  
     if(authentication.isAuthenticated()) {
        token =   jwtService.generateToken(authRequest.getUsername());
     }
     else {
	  throw  new UsernameNotFoundException(" invalid  request ");
     }
	  
	return token; 
     
     }
     
     
}
