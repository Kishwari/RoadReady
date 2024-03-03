package com.hexaware.roadready.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    
	Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	
	@Override
	public Customers addCustomer(CustomerDTO customerdto) {
		Customers customer = new Customers();
		customer.setCustomerId(customerdto.getCustomerId());
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmailAddress(customerdto.getEmailAddress());
		customer.setUsername(customerdto.getUsername());
		customer.setPassword(passwordEncoder.encode(customerdto.getPassword()));
		customer.setPhoneNumber(customerdto.getPhoneNumber());

    	logger.info("Added a new customer");

		customer.setRole("ROLE_CUSTOMER");

		return customerRepo.save(customer);
	}
	



	@Override
	public CustomerDTO getCustomerById(int customerId) throws CustomerNotFoundException{
		Customers customer = customerRepo.findById(customerId).orElse(null);
		if(customer !=null) {
		CustomerDTO customerdto=new CustomerDTO();
		customerdto.setCustomerId(customer.getCustomerId());
		customerdto.setFirstName(customer.getFirstName());
		customerdto.setLastName(customer.getLastName());
		customerdto.setEmailAddress(customer.getEmailAddress());
		customerdto.setUsername(customer.getUsername());
		customerdto.setPassword(customer.getPassword());
		customerdto.setPhoneNumber(customer.getPhoneNumber());
		return customerdto;
		}
		throw new CustomerNotFoundException("custome with id " + customerId + "not found");
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customers> customersList = customerRepo.findAll();
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		for(Customers customer : customersList) {
			CustomerDTO customerdto = new CustomerDTO();
			customerdto.setCustomerId(customer.getCustomerId());
			customerdto.setFirstName(customer.getFirstName());
			customerdto.setLastName(customer.getLastName());
			customerdto.setEmailAddress(customer.getEmailAddress());
			customerdto.setUsername(customer.getUsername());
			customerdto.setPassword(customer.getPassword());
			customerdto.setPhoneNumber(customer.getPhoneNumber());
			
			customerDTOList.add(customerdto);
		}
		return customerDTOList;
	}

	@Override
	public String deleteCustomer(int customerId) {
		customerRepo.deleteById(customerId);
		Customers deletedCustomer = customerRepo.findById(customerId).orElse(null);
		if(deletedCustomer != null) {
			return "customer deletion unsuccesfull";
		}
		return "customer " + customerId +" deleted successfully";
	}
	
	@Override
	public Customers updateCustomer(CustomerDTO customerdto) throws  CustomerNotFoundException
{
		Customers customer = new Customers();
		if(customer!=null) {
		customer.setCustomerId(customerdto.getCustomerId());
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmailAddress(customerdto.getEmailAddress());
		customer.setUsername(customerdto.getUsername());
		customer.setPassword(passwordEncoder.encode(customerdto.getPassword()));
		customer.setPhoneNumber(customerdto.getPhoneNumber());

    	logger.info("Updated an existing customer");

		customer.setRole("ROLE_CUSTOMER");

		return customerRepo.save(customer);
		}
		throw new CustomerNotFoundException("customer not found");

	}
	
	@Override
	 public Long countCustomers() {
	        return customerRepo.count();
	    }

	
	@Override
    public boolean checkIfCustomerExists(String username) {
        return customerRepo.existsByUsername(username);
    }

    @Override
    public String updateCustomerPassword(String username, String newPassword) {
        Customers customer = customerRepo.findByUsername(username).orElse(null);
        customer.setPassword(passwordEncoder.encode(newPassword));
        customerRepo.save(customer);
        return "Customer password updated successfully";
    }
	
	
}