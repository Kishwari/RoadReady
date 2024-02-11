package com.hexaware.roadready.restcontroller;

import java.util.List;

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

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.service.ICarService;

@RestController
@RequestMapping("/roadready/cars")
public class CarRestController {
	
	@Autowired
	ICarService carService;
	
	@PostMapping("/addCar")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Cars	addCar(@RequestBody CarDTO car) {
		return carService.addCar(car);
	}
    
	@GetMapping("/getCarById/{carId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public CarDTO	getCarById(@PathVariable int carId) throws CarNotFoundException {
		CarDTO car= carService.getCarById(carId);
		if(car==null) {
			throw new CarNotFoundException("car with id " + carId + "not present");
		}
		return car;
	}
	
	@GetMapping("/getAllCars")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<CarDTO>	getAllCars(){
		return carService.getAllCars();
	}
	
	@DeleteMapping("/deleteCarById/{carId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String deleteCar(@PathVariable int carId) {
		return carService.deleteCar(carId);
	}
	
	@PutMapping("/updateCarDetails")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Cars	updateCar(@RequestBody CarDTO car) throws CarNotFoundException {
		Cars checkCar = carService.updateCar(car);
		if(checkCar == null) {
			throw new CarNotFoundException("car not present");
		}
		return checkCar;
	}
     	
    
    @PutMapping("/discountOnCarByMake/{make}/{discountPrice}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Cars> discountOnCarPrice(@PathVariable String make ,@PathVariable double discountPrice) throws CarNotFoundException {
    	List<Cars>  cars = carService.discountOnCarPriceByMake(make, discountPrice);
    	if(cars.isEmpty()) {
    		throw new CarNotFoundException("car with make " + make+ "not present");
    	}
    	return cars;
    }
    
    @PutMapping("/updateCarPrice/{carId}/{newPrice}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Cars updateCarPrice(@PathVariable int carId , @PathVariable double newPrice) throws CarNotFoundException {
    	Cars car = carService.updateCarPrice(carId, newPrice);
    	if(car == null) {
    		throw new CarNotFoundException("car with id " + carId + "not present");
    	}
    	return car;
    }
    
    
    @GetMapping("/getAvailableCars")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
 	public List<Cars> getAvailableCars(){
 		return carService.getAvailableCars();
 	}
    
    @GetMapping("/searchCars/{location}/{make}/{model}")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public List<Cars> searchCars(@PathVariable String location , @PathVariable String make,@PathVariable String model) throws CarNotFoundException{
 	   List<Cars> cars= carService.searchCars(location , make , model);
 	   if(cars.isEmpty()) {
 		   throw new CarNotFoundException(make +" " + model + " car in location" + location + "not avaialble");
 	   }
        return cars;
    }
    
    
}
