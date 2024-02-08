package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.service.IAgentService;

@RestController
@RequestMapping("/roadready/agents")
public class AgentRestController {

	@Autowired
	IAgentService service;
	
     
	 @GetMapping("/checkin/{reservationId}")
	 public String completeCheckIn(@PathVariable int reservationId) {		// no idea about mapping
		 return service.completeCheckIn(reservationId);

	 }
	 @GetMapping("/checkout/{reservationId}")
	 public String completeCheckOut(@PathVariable int reservationId) { 		// no idea about mapping
		 return service.completeCheckOut(reservationId);

	 }
	
	 @PutMapping("/updateCarAvailability/{carId}")
    public CarDTO updateCarAvailability(@PathVariable int carId) throws CarNotFoundException {
		 CarDTO car = service.updateCarAvailability(carId);
		 if(car==null) {
			 throw new CarNotFoundException("car with id " + carId + "not present");
		 }
		 return car;
	 }
	 @GetMapping("/getCustomerIdentity/{customerId}")	
    public CustomerDTO  verifyIdentity(@PathVariable int customerId) throws CustomerNotFoundException {
		 CustomerDTO customer = service.verifyIdentity(customerId);
		 if(customer== null) {
			 throw new CustomerNotFoundException();
		 }
         return customer;
	 }
    
    /*@PostMapping("/generateAgentReport")			// I think we need agentId here to get that particular agent's report
    public String agentReport() {                   //J : i think we need seperate report entity
		 return service.agentReport();

    }
    
    @GetMapping("/getCarMaintenanceAlerts/{carId}")
    public String provideCarMaintenanceAlerts(@PathVariable int carId) {
		 return service.provideCarMaintenanceAlerts(carId);         //J :i think we need carId from report entity so that we can get under maintenance

    } */
	 

     @GetMapping("/carMaintenanceReport/{maintenance}")
	 public String carMaintenanceReport(@PathVariable String maintenance)   {
		 return service.carMaintenanceReport(maintenance);
	 }
     
     
}
