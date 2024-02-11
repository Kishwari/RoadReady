package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CarNotFoundException;

public interface ICarService {
	
        public List<Cars> getAvailableCars(); 
	
	    List<Cars> searchCars(String location,String make,String model) throws CarNotFoundException;
	
	    public Cars	addCar(CarDTO car);
		
		public CarDTO	getCarById(int carId)throws CarNotFoundException;
		
		public List<CarDTO>	getAllCars();
		
		public String deleteCar(int carId);
		
		public Cars	updateCar(CarDTO car) throws CarNotFoundException;

	    public List<Cars> discountOnCarPriceByMake(String make, double discountPrice) throws CarNotFoundException;
	    
	    public Cars updateCarPrice(int carId , double newPrice) throws CarNotFoundException;
	    
	   
}
