package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;



public interface IAdminService {
	void manageCustomers(Customers customer);
	   
    void manageCars(Cars car);
    
    List <Reservations> viewAllReservations();
    
    List<Payments> viewAllPayments();
    
    
    void discountOnCarPrice(double actualPrice, double discountPrice);
    
    void updateCarPrice(double oldPrice , double newPrice);
    
    
    //Report generateReports(Date startDate, Date endDate, ReportType reportType);
    
    void manageFeedbackAndDisputes();
    
    void carFleetManagement( );
}
