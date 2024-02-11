package com.hexaware.roadready.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.hexaware.roadready.dto.AdminDTO;
import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.service.IAdminService;
import com.hexaware.roadready.service.IAgentService;
import com.hexaware.roadready.service.ICarService;
import com.hexaware.roadready.service.ICustomerService;
import com.hexaware.roadready.service.IFeedBackService;
import com.hexaware.roadready.service.IPaymentService;
import com.hexaware.roadready.service.IReservationService;

@RestController
@RequestMapping("/roadready/admin")
public class AdminRestController {
	
	Logger logger=LoggerFactory.getLogger(AdminRestController.class);
	
	@Autowired
	IAdminService adminService;

	
    @GetMapping("/revenueReportBetweenDates/{startDate}/{endDate}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String revenueReportBetweenDates(@PathVariable LocalDate startDate , @PathVariable LocalDate endDate ) {
    	return adminService.revenueReportBetweenDates(startDate , endDate);
    }
    
    @GetMapping("/revenueGeneratedByCustomer/{customerId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String revenueReportGeneratedByCustomer(@PathVariable int customerId) {
    	logger.info("Now generating revenue for customer with Id : "+customerId);
    	return adminService.revenueReportGeneratedByCustomer(customerId);
    }
    
    @GetMapping("/totalRevenueReport")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String totalRevenueReport() {
    	logger.info("Now generating total revenue report");
    	return adminService.totalRevenueReport();
    }
    
    @PostMapping("/registerAdmin")
<<<<<<< HEAD
    public Admin addAdmin(AdminDTO admindto) {
    	logger.info("Now Registering");
=======
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Admin addAdmin(@RequestBody AdminDTO admindto) {
>>>>>>> joshitha
		return adminService.addAdmin(admindto);
		
	}
    
    
}
