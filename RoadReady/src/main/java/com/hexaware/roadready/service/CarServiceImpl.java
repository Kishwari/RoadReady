package com.hexaware.roadready.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.repository.CarRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class CarServiceImpl implements ICarService{
    
	@Autowired
	CarRepository carRepo;
	
	@Override
	public List<Cars> getAvailableCars() {
		
		return carRepo.getAvailableCars();
	}
	
	@Override
	public List<Cars> searchCars(String location, String make, String model) {
        List<Cars> availableCars = carRepo.getAvailableCars();
        return availableCars.stream()
                .filter(car -> car.getMake().equals(make) && car.getModel().equals(model)
                && car.getLocation().equals(location) ) .collect(Collectors.toList());
	}

	
	@Override
	public Cars addCar(CarDTO cardto) {
		
		Cars car = new Cars();
		car.setCarId(cardto.getCarId());
		car.setMake(cardto.getMake());
		car.setModel(cardto.getModel());
		car.setLocation(cardto.getLocation());
		car.setCarStatus(cardto.getCarStatus());
		car.setSpecification(cardto.getSpecifications());
		car.setPassengerCapacity(cardto.getPassengerCapacity());
		car.setDailyRate(cardto.getDailyRate());
		return carRepo.save(car);
	}

	@Override
	public CarDTO getCarById(int carId) {
		Cars car = carRepo.findById(carId).orElse(null);
		CarDTO cardto=new CarDTO();
		cardto.setCarId(car.getCarId());
		cardto.setMake(car.getMake());
		cardto.setModel(car.getModel());
		cardto.setCarStatus(car.getCarStatus());
		cardto.setSpecifications(car.getSpecification());
		cardto.setLocation(car.getLocation());
		cardto.setPassengerCapacity(car.getPassengerCapacity());
		cardto.setDailyRate(car.getDailyRate());
		return cardto;
	}

	@Override
	public List<CarDTO> getAllCars() {
		List<Cars> carsList = carRepo.findAll();
		List<CarDTO> carDTOList = new ArrayList<>();
		for(Cars car : carsList) {
			CarDTO cardto=new CarDTO();
			cardto.setCarId(car.getCarId());
			cardto.setMake(car.getMake());
			cardto.setModel(car.getModel());
			cardto.setCarStatus(car.getCarStatus());
			cardto.setSpecifications(car.getSpecification());
			cardto.setLocation(car.getLocation());
			cardto.setPassengerCapacity(car.getPassengerCapacity());
			cardto.setDailyRate(car.getDailyRate());
			
			carDTOList.add(cardto);
		}
		return carDTOList;
	}

	@Override
	public String deleteCar(int carId) {
		carRepo.deleteById(carId);
		Cars deletedCar = carRepo.findById(carId).orElse(null);
		if(deletedCar != null) {
			return "car deletion unsuccesfull";
		}
		return "car " + carId +" deleted successfully";
	}
	

	@Override
	public Cars updateCar(CarDTO cardto) {
		Cars car = new Cars();
		car.setCarId(cardto.getCarId());
		car.setMake(cardto.getMake());
		car.setModel(cardto.getModel());
		car.setLocation(cardto.getLocation());
		car.setCarStatus(cardto.getCarStatus());
		car.setSpecification(cardto.getSpecifications());
		car.setPassengerCapacity(cardto.getPassengerCapacity());
		car.setDailyRate(cardto.getDailyRate());
		return carRepo.save(car);
	}
	
	
	@Override
	public List<Cars> discountOnCarPriceByMake(String make, double discountPrice) throws CarNotFoundException {
       
        carRepo.discountOnCarPriceByMake(make, discountPrice);
  
        List<Cars> updatedCars = carRepo.findByMake(make);
        
        if (updatedCars.isEmpty()) {
            throw new CarNotFoundException("No cars found with make: " + make);
        }
        
        return updatedCars;

	}

	@Override
	public Cars updateCarPrice(int carId , double newPrice) throws CarNotFoundException {
	     Cars car = new Cars();
			Cars existingCar = carRepo.findById(carId).orElse(null);
	        if (existingCar != null) {      
	           existingCar.setDailyRate(newPrice);
	           car = carRepo.save(existingCar);
	        } 
	        else {
	              throw new CarNotFoundException("no cars found with id" + carId);
		}
	         return car;
		
	}
}
