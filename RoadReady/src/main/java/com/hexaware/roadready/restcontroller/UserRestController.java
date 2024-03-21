package com.hexaware.roadready.restcontroller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AuthRequest;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.repository.AdminRepository;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.service.AgentServiceImpl;
import com.hexaware.roadready.service.CustomerServiceImpl;
import com.hexaware.roadready.service.JwtService;

import jakarta.validation.Valid;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/roadready/user")
public class UserRestController {

	Logger logger=LoggerFactory.getLogger(AgentRestController.class);
	
	     @Autowired
	     CustomerServiceImpl customerService;
	     
	     @Autowired
	     AgentServiceImpl agentService;
	     
	     @Autowired
	     CustomerRepository customerRepo;
	     @Autowired
	     AdminRepository adminRepo;
	     @Autowired
	     AgentRepository agentRepo;
		
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

    	 
    	 Optional<Customers> customer = customerRepo.findByUsername(authRequest.getUsername());
    	 Optional<Admin> admin = adminRepo.findByUsername(authRequest.getUsername());
    	 Optional<Agent> agent = agentRepo.findByUsername(authRequest.getUsername());
    	 
    	 
    	 
    	 
    	 if (customer.isPresent()) {
    		    String role = customer.get().getRole();
    		    int customerId=customer.get().getCustomerId();
    		    token = jwtService.generateToken(authRequest.getUsername(), role , customerId);
    		    logger.info("Token: " + token);
    		} else if (admin.isPresent()) {
    		    String role = admin.get().getRole();
    		    int adminId=admin.get().getAdminId();
    		    token = jwtService.generateToken(authRequest.getUsername(), role , adminId);
    		    logger.info("Token: " + token);
    		} else if (agent.isPresent()) {
    		    String role = agent.get().getRole();
    		    int agentId=agent.get().getAgentId();
    		    token = jwtService.generateToken(authRequest.getUsername(), role , agentId);
    		    logger.info("Token: " + token);
    		} else {
    		    logger.error("User not found in the database");
    		}
	  
	
     
     }else {
			
			logger.info("invalid");
			
			 throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
     
     
     }
     return token; 
}
     
 
     
}
