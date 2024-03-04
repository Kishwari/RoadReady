package com.hexaware.roadready.restcontroller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AdminDTO;
import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.service.IAdminService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
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
    	logger.info(String.format("Now generating revenue for customer with Id : %d ",customerId));
    	return adminService.revenueReportGeneratedByCustomer(customerId);
    }
    
    @GetMapping("/totalRevenueReport")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String totalRevenueReport() {
    	logger.info("Now generating total revenue report");
    	return adminService.totalRevenueReport();
    }
    
    @GetMapping("/totalRevenue")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Double totalRevenue() {
    	logger.info("Now generating total revenue");
    	return adminService.totalRevenue();
    }
    
  
    
}
