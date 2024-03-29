package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Cars;

import com.hexaware.roadready.exceptions.CarNotFoundException;

public interface ICarService {
	
        public List<CarDTO> getAvailableCars(); 
	
	    List<Cars> searchCars(String location,String make,String model) throws CarNotFoundException;
	
	    public Cars	addCar(CarDTO car);
		
		public CarDTO	getCarById(int carId)throws CarNotFoundException;
		
		public List<CarDTO>	getAllCars();
		
		public String deleteCar(int carId);
		
		public Cars	updateCar(CarDTO car);

	    public List<CarDTO> discountOnCarPriceByMake(String make, double discountPrice) throws CarNotFoundException;
	    
	    public Cars updateCarPrice(int carId , double newPrice) throws CarNotFoundException;
	    
	    public List<CarDTO> getCarByLocation(String location);
	    
	    public List<CarDTO> getCarByPassengerCapacity(int passengers);
	    
	    public List<CarDTO> getCarByMake(String make);
	    
	    public List<CarDTO> getCarBySpecification(String specification);
	    
	    public Long countCars();
	    
	   
}
