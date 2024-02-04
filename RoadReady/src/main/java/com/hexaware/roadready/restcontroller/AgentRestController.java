package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.service.IAgentService;

@RestController
@RequestMapping("/roadready/agents")
public class AgentRestController {

	@Autowired
	IAgentService service;
	
     @GetMapping("/checkin/{reservationId)")
	 public String completeCheckIn(@PathVariable int reservationId) {		// no idea about mapping
		 return service.completeCheckIn(reservationId);

	 }
	 @GetMapping("/checkout/{reservationId}")
	 public String completeCheckOut(@PathVariable int reservationId) { 		// no idea about mapping
		 return service.completeCheckOut(reservationId);

	 }
	
	 @PutMapping("/updateCarAvailability/{carId}")
    public String updateCarAvailability(@PathVariable int carId) {
		 return service.updateCarAvailability(carId);
	 }
	 
	 @GetMapping("/getCustomerIdentity/{customerId}")	
    public String verifyIdentity(@PathVariable int customerId) {   
		 return service.verifyIdentity(customerId);

	 }
    
    @PostMapping("/AgentReport")			//I: I think we need agentId here to get that particular agent's report
    public String agentReport() {          //J : i think we need a seperate entity report to store 
		 return service.agentReport();

    }
    
    @GetMapping("/getCarMaintenanceAlerts/{carId}")
    public String provideCarMaintenanceAlerts(@PathVariable int carId) {  //J:if we have entity for report we can get cars which are under maintanace
		 return service.provideCarMaintenanceAlerts(carId);

    }
}
