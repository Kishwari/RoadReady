package com.hexaware.roadready.service;

import java.time.LocalDate;

import com.hexaware.roadready.dto.AdminDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.PasswordDTO;
import com.hexaware.roadready.entities.Admin;



public interface IAdminService {
	
	
	
	public Admin addAdmin(AdminDTO admindto);
	
  
    
    public String revenueReportBetweenDates(LocalDate startDate, LocalDate endDate);
    
    public String revenueReportGeneratedByCustomer(int customerId);
    
    public String totalRevenueReport();
    
    public double totalRevenue();
    
    boolean checkIfAdminExists(String username);
    String updateAdminPassword(String username, String newPassword);

}
