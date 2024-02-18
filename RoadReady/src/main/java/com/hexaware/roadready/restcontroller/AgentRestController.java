package com.hexaware.roadready.restcontroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.CustomerIdentity;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerIdentityNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.service.IAgentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roadready/agents")
public class AgentRestController {

	Logger logger=LoggerFactory.getLogger(AgentRestController.class);

	
	@Autowired
	IAgentService agentService;
	
	
     
	 @GetMapping("/checkin/{reservationId}")
	 @PreAuthorize("hasAnyAuthority('ROLE_AGENT','ROLE_ADMIN')")
	 public String completeCheckIn(@PathVariable int reservationId) {		
		 return agentService.completeCheckIn(reservationId);

	 }
	 @GetMapping("/checkout/{reservationId}/{carStatus}")
	 @PreAuthorize("hasAnyAuthority('ROLE_AGENT','ROLE_ADMIN')")
	 public String completeCheckOut(@PathVariable int reservationId , @PathVariable String carStatus) { 		
		 return agentService.completeCheckOut(reservationId, carStatus);

	 }
	
	 @PutMapping("/updateCarAvailability/{carStatus}/{carId}")
	 @PreAuthorize("hasAnyAuthority('ROLE_AGENT','ROLE_ADMIN')")
    public Cars updateCarAvailability(@PathVariable String carStatus , @PathVariable int carId) {
		 Cars car=new Cars();
		try {
			car = agentService.updateCarAvailability(carStatus, carId);
		} catch (CarNotFoundException e) {

			e.printStackTrace();
		}
		 return car;
	 }
	
	
	 
	 @PostMapping("/createNewAgentAccount")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	   public Agent addAgent(@Valid @RequestBody AgentDTO agentdto) {
		 logger.info("Now adding agent using addAgent method");
	    	return agentService.addAgent(agentdto);
	    }
		
	    @GetMapping("/getAgentById/{agentId}")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public AgentDTO getAgentById(@PathVariable int agentId) {
	    	AgentDTO agentdto = new AgentDTO();
	    	try {
				agentdto= agentService.getAgentById(agentId);
			} catch (AgentNotFoundException e) {
				e.printStackTrace();
			}
	    	return agentdto;
	    }
	    
	    @GetMapping("/getAllAgents")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public List<Agent> getAllAgents(){
	    	logger.info("Getting list of agents");
	    	return agentService.getAllAgents();
	    }
	    @DeleteMapping("/deleteAgentById/{agentId}")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public String deleteAgent(@PathVariable int agentId) {
	    	return agentService.deleteAgent(agentId);
	    }
	    
	    @PutMapping("/updateAgentById/{agentId}")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public Agent updateAgent(@PathVariable int agentId ,@Valid @RequestBody AgentDTO agent) {
	    	return agentService.updateAgent(agentId, agent);
	    }
  
	    @GetMapping(value = "/verifyCustomerIdentity/{customerId}", produces = MediaType.APPLICATION_PDF_VALUE)
	    @PreAuthorize("hasAnyAuthority('ROLE_AGENT','ROLE_ADMIN')")
	    public ResponseEntity<byte[]> getIdentity(@PathVariable int customerId)  throws CustomerIdentityNotFoundException {
		    return agentService.verifyIdentity(customerId);
		   
		        
		     }
	 
	 
     @GetMapping("/carMaintenanceReport")
     @PreAuthorize("hasAnyAuthority('ROLE_AGENT','ROLE_ADMIN')")
	 public String carMaintenanceReport()   {
		 return agentService.carMaintenanceReport();
	 }
     
     
}


/* @PostMapping("/addAgent")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public Agent addAgent(@Valid @RequestBody AgentDTO agentdto) {
   	logger.info("Now adding agent using addAgent method");
   	return agentService.addAgent(agentdto);
   }*/