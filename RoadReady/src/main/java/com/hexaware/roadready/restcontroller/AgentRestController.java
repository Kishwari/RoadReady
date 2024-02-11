package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.service.IAgentService;

@RestController
@RequestMapping("/roadready/agents")
public class AgentRestController {

	Logger logger=LoggerFactory.getLogger(AgentRestController.class);

	
	@Autowired
	IAgentService agentService;
	
     
	 @GetMapping("/checkin/{reservationId}")
	 @PreAuthorize("hasAuthority('ROLE_AGENT' , 'ROLE_ADMIN')")
	 public String completeCheckIn(@PathVariable int reservationId) {		// no idea about mapping
		 return agentService.completeCheckIn(reservationId);

	 }
	 @GetMapping("/checkout/{reservationId}/{carStatus}")
	 @PreAuthorize("hasAuthority('ROLE_AGENT', 'ROLE_ADMIN')")
	 public String completeCheckOut(@PathVariable int reservationId , @PathVariable String carStatus) { 		// no idea about mapping
		 return agentService.completeCheckOut(reservationId, carStatus);

	 }
	
	 @PutMapping("/updateCarAvailability/{carStatus}/{carId}")
	 @PreAuthorize("hasAuthority('ROLE_AGENT')")
    public Cars updateCarAvailability(@PathVariable String carStatus , @PathVariable int carId) {
		 Cars car=new Cars();
		try {
			car = agentService.updateCarAvailability(carStatus, carId);
		} catch (CarNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return car;
	 }
	
	 @PostMapping("/addAgent")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_AGENT')")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public Agent addAgent(@RequestBody AgentDTO agentdto) {
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
				// TODO Auto-generated catch block
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
	    public Agent updateAgent(@PathVariable int agentId , @RequestBody AgentDTO agent) {
	    	return agentService.updateAgent(agentId, agent);
	    }
    /*@PostMapping("/generateAgentReport")			// I think we need agentId here to get that particular agent's report
    public String agentReport() {                   //J : i think we need seperate report entity
		 return service.agentReport();

    }
    
    @GetMapping("/getCarMaintenanceAlerts/{carId}")
    public String provideCarMaintenanceAlerts(@PathVariable int carId) {
		 return service.provideCarMaintenanceAlerts(carId);         //J :i think we need carId from report entity so that we can get under maintenance

    } */
	 
	 @GetMapping("/verifyCustomerIdentity/{customerId}")
	 @PreAuthorize("hasAuthority('ROLE_AGENT')")
	   public CustomerDTO  verifyIdentity(@PathVariable int customerId) throws CustomerNotFoundException {
			 CustomerDTO customer = agentService.verifyIdentity(customerId);
			 if(customer== null) {
				 throw new CustomerNotFoundException("customer with Id" + customerId + "not found");
			 }
	        return customer;
		 }
     @GetMapping("/carMaintenanceReport")
     @PreAuthorize("hasAuthority('ROLE_AGENT')")
	 public String carMaintenanceReport()   {
		 return agentService.carMaintenanceReport();
	 }
     
     
}
