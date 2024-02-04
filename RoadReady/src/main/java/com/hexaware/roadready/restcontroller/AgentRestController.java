package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.service.IAgentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/roadready/agents")
public class AgentRestController {

	@Autowired
	IAgentService service;
	

	 public String completeCheckIn(@RequestBody int reservationId) {		// no idea about mapping
		 return service.completeCheckIn(reservationId);

	 }
	 
	 public String completeCheckOut(@RequestBody int reservationId) { 		// no idea about mapping
		 return service.completeCheckOut(reservationId);

	 }
	
	 @PutMapping("/updateCarAvailability")
    public String updateCarAvailability(@RequestBody int carId) {
		 return service.updateCarAvailability(carId);
	 }
	 @GetMapping("/getVerifyIdentity")	
    public String verifyIdentity(@RequestBody int customerId) {
		 return service.verifyIdentity(customerId);

	 }
    
    @GetMapping("/getAgentReport")			// I think we need agentId here to get that particular agent's report
    public String agentReport() {
		 return service.agentReport();

    }
    
    @GetMapping("/getCarMaintenanceAlerts")
    public String provideCarMaintenanceAlerts(@RequestBody int carId) {
		 return service.provideCarMaintenanceAlerts(carId);

    }
}
