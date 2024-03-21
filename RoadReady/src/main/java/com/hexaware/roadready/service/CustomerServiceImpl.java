package com.hexaware.roadready.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.PaymentAndReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.repository.CarRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    
	Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
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
	
public void sendEmailNotification(Long id) {
    	
    	Customers customer=customerRepo.findByCustomerId(id);
        String email=customer.getEmailAddress();
        String name=customer.getFirstName();
    	 
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email); // Set the recipient email address
        message.setSubject("License Verification");
        message.setText(" Hey " + name + " \n\n Your license has been successfully verified . Have a happy ride " + "\n\n Thanks & Regards " +"\n Team RoadReady"); // Customize your email message

        javaMailSender.send(message);
    }
    
    
    

        public ByteArrayInputStream generateInvoicePdf(PaymentAndReservationDTO dto) {
            Document document = new Document();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Customers customer = customerRepo.findById(dto.getCustomerId()).orElse(null);
            Cars car=carRepo.findById(dto.getCarId()).orElse(null);           

            try {
                PdfWriter.getInstance(document, out);
                document.open();
                document.add(new Paragraph("Dear "+ customer.getFirstName()+ "\nYou have successfully booked  "+ car.getMake() + " 's " + car.getModel()));
                document.add(new Paragraph("Your Payment And Booking Details:"));
                document.add(new Paragraph("CustomerId : " +dto.getCustomerId()+
                                           "\nCarId : " +dto.getCarId()+
                                           "\nAmount Paid : " + dto.getAmountPaid()+
                                           "\nMode Of Payment : "+dto.getModeOfPayment()+
                                           "\nDate Of PickUp : "+dto.getDateOfPickup()+
                                           "\nDate Of DropOff :"+dto.getDateOfDropOff()));
               
                document.close();
                sendPaymentDetailsPdf(customer.getEmailAddress() , out.toByteArray() );
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            return new ByteArrayInputStream(out.toByteArray());
        }
    
    public void sendPaymentDetailsPdf( String customerEmail , byte[] attachment) {
    	
    	  MimeMessage message = javaMailSender.createMimeMessage();

          try {
              MimeMessageHelper helper = new MimeMessageHelper(message, true);

              helper.setTo(customerEmail);
              helper.setSubject("Payment Details");
              helper.setText("Dear Customer , please find your payment details attached as document.");

              // Attach PDF to the email
              helper.addAttachment("invoice.pdf", new ByteArrayResource(attachment));

              javaMailSender.send(message);
          } catch (MessagingException  e) {
              e.printStackTrace();
          }
      }
}
