package com.hexaware.roadready.service;

import java.time.LocalDate;

import com.hexaware.roadready.dto.AdminDTO;

import com.hexaware.roadready.entities.Admin;

import jakarta.validation.Valid;



public interface IAdminService {
	
  
    
    public String revenueReportBetweenDates(LocalDate startDate, LocalDate endDate);
    
    public String revenueReportGeneratedByCustomer(int customerId);
    
    public String totalRevenueReport();
    
    public double totalRevenue();
    
    boolean checkIfAdminExists(String username);
    String updateAdminPassword(String username, String newPassword);

	public Admin updateAdminDetails( AdminDTO admindto);

	public Admin addAdmin(AdminDTO admindto);

}
