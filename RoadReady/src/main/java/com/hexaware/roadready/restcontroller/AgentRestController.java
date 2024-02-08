package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.service.IAgentService;

@RestController
@RequestMapping("/roadready/agents")
public class AgentRestController {

	@Autowired
	IAgentService agentService;
	
     
	 @GetMapping("/checkin/{reservationId}")
	 public String completeCheckIn(@PathVariable int reservationId) {		// no idea about mapping
		 return agentService.completeCheckIn(reservationId);

	 }
	 @GetMapping("/checkout/{reservationId}/{carStatus}")
	 public String completeCheckOut(@PathVariable int reservationId , @PathVariable String carStatus) { 		// no idea about mapping
		 return agentService.completeCheckOut(reservationId, carStatus);

	 }
	
	 @PutMapping("/updateCarAvailability/{carStatus}/{carId}")
    public Cars updateCarAvailability(@PathVariable String carStatus , @PathVariable int carId) throws CarNotFoundException {
		 Cars car = agentService.updateCarAvailability(carStatus, carId);
		 if(car==null) {
			 throw new CarNotFoundException("car with id " + carId + "not present");
		 }
		 return car;
	 }
	 @GetMapping("/verifyCustomerIdentity/{customerId}")	
    public Customers  verifyIdentity(@PathVariable int customerId) throws CustomerNotFoundException {
		 Customers customer = agentService.verifyIdentity(customerId);
		 if(customer== null) {
			 throw new CustomerNotFoundException("customer with Id" + customerId + "not found");
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
	 

     @GetMapping("/carMaintenanceReport")
	 public String carMaintenanceReport()   {
		 return agentService.carMaintenanceReport();
	 }
     
     
}
