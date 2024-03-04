package com.hexaware.roadready.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.repository.CarRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class CarServiceImpl implements ICarService {

	Logger logger=LoggerFactory.getLogger(CarServiceImpl.class);

	@Autowired
	CarRepository carRepo;

	@Override
	public List<CarDTO> getAvailableCars() {
    	logger.info("List of cars that are available at the moment");
		List<Cars> carList=  carRepo.getAvailableCars();
		List<CarDTO> carDTOList = new ArrayList<>();
		for (Cars car : carList) {
			CarDTO cardto = new CarDTO();
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
	public List<Cars> searchCars(String location, String make, String model) throws CarNotFoundException{
		List<Cars> availableCars = carRepo.getAvailableCars();
		if(availableCars.isEmpty()) {
			throw new CarNotFoundException("car not present");
		}
		return availableCars.stream().filter(
				car -> car.getMake().equals(make) && car.getModel().equals(model) && car.getLocation().equals(location))
				.collect(Collectors.toList());
	}

	@Override
	public Cars addCar(CarDTO cardto) {

		Cars car = new Cars();
		
		car.setMake(cardto.getMake());
		car.setModel(cardto.getModel());
		car.setLocation(cardto.getLocation());
		car.setCarStatus(cardto.getCarStatus());
		car.setSpecification(cardto.getSpecifications());
		car.setPassengerCapacity(cardto.getPassengerCapacity());
		car.setDailyRate(cardto.getDailyRate());
    	logger.info("Car has been added using addCar method");
		return carRepo.save(car);
	}

	@Override
	public CarDTO getCarById(int carId) throws CarNotFoundException{
		Cars car = carRepo.findById(carId).orElse(null);
		if( car!=null) {
		CarDTO cardto = new CarDTO();
		cardto.setCarId(car.getCarId());
		cardto.setMake(car.getMake());
		cardto.setModel(car.getModel());
		cardto.setCarStatus(car.getCarStatus());
		cardto.setSpecifications(car.getSpecification());
		cardto.setLocation(car.getLocation());
		cardto.setPassengerCapacity(car.getPassengerCapacity());
		cardto.setDailyRate(car.getDailyRate());
		return cardto;}
		throw new CarNotFoundException("car not present");
	}

	@Override
	public List<CarDTO> getAllCars() {
		List<Cars> carsList = carRepo.findAll();
		List<CarDTO> carDTOList = new ArrayList<>();
		for (Cars car : carsList) {
			CarDTO cardto = new CarDTO();
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
    	logger.info("Deleting Car");
		Cars deletedCar = carRepo.findById(carId).orElse(null);
		if (deletedCar != null) {
			return "car deletion unsuccesfull";
		}
		return "car " + carId + " deleted successfully";
	}

	@Override
	public Cars updateCar(CarDTO cardto)  {
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
	public List<CarDTO> discountOnCarPriceByMake(String make, double discountPrice) throws CarNotFoundException {

		carRepo.discountOnCarPriceByMake(make, discountPrice);

		List<Cars> updatedCars = carRepo.findByMake(make);
    	logger.warn("Might throw exception CarNotFoundException ");
		if (updatedCars.isEmpty()) {
			throw new CarNotFoundException("No cars found with make: " + make);
		}
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Cars car : updatedCars) {
			CarDTO cardto = new CarDTO();
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
	public Cars updateCarPrice(int carId, double newPrice) throws CarNotFoundException {
		Cars car = new Cars();
		Cars existingCar = carRepo.findById(carId).orElse(null);
    	logger.warn("Might throw exception CarNotFoundException ");
		if (existingCar != null) {
			existingCar.setDailyRate(newPrice);
			 car = carRepo.save(existingCar);
		} else {
			throw new CarNotFoundException("no cars found with id" + carId);
		}
		return car;

	}

	@Override
	public List<CarDTO> getCarByLocation(String location) {
		List<Cars> carList=  carRepo.findByLocation(location);
		List<CarDTO> carDTOList = new ArrayList<>();
		for (Cars car : carList) {
			CarDTO cardto = new CarDTO();
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
	public List<CarDTO> getCarByPassengerCapacity(int passengers) {
		
		List<Cars> carList=  carRepo.findByPassengerCapacity(passengers);
		List<CarDTO> carDTOList = new ArrayList<>();
		for (Cars car : carList) {
			CarDTO cardto = new CarDTO();
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
	public List<CarDTO> getCarByMake(String make) {
		List<Cars> carList=  carRepo.findByMake(make);
		List<CarDTO> carDTOList = new ArrayList<>();
		for (Cars car : carList) {
			CarDTO cardto = new CarDTO();
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
	public List<CarDTO> getCarBySpecification(String specification) {
		List<Cars> carList=  carRepo.findBySpecification(specification);
		List<CarDTO> carDTOList = new ArrayList<>();
		for (Cars car : carList) {
			CarDTO cardto = new CarDTO();
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
	public Long countCars() {
		
		return carRepo.count();
	}
}
