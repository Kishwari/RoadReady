package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.service.ICustomerService;

@RestController
@RequestMapping("/roadready/customers")
public class CustomerRestController {
	
   @Autowired
   ICustomerService service;
   
   @GetMapping("/getAvailableCars")
	public List<Cars> getAvailableCars(){
		return service.getAvailableCars();
	}
   
   @GetMapping("/searchCars/{location}/{make}/{model}")
   public List<Cars> searchCars(@PathVariable String location , @PathVariable String make,@PathVariable String model){
	   return service.searchCars(location , make , model);
  
   }
   
}

