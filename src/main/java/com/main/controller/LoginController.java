package com.main.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.RoomDao;
import com.main.entity.Booking;
import com.main.entity.Customer;
import com.main.service.CustomerService;
import com.main.service.HotelService;

@RestController
public class LoginController {
	@Autowired
	CustomerService custservice;
	@Autowired
	HotelService hotelservice;
	@Autowired
	RoomDao roomdao;

	
	   @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	   public ResponseEntity createDetails(@RequestBody Customer cust) {
		   
		   String pass= cust.getPassword();
		   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		   String encodedPassword = passwordEncoder.encode(pass);
		   cust.setPassword(encodedPassword);
		   Optional<Customer> cus= custservice.findById(cust.getCustomer_Id());
		   try {
		   if(!cus.isEmpty()) {
			   custservice.saveOrUpdate(cust,cust.getCustomer_Id());
			   return new ResponseEntity<String>("User Updated", HttpStatus.OK);
		   }
		   else {
			   custservice.save(cust);
			   return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
		   }
		   }catch(Exception ex) {
			   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
	   }
	   @RequestMapping(value = "/Login", method = RequestMethod.POST)
	   public ResponseEntity updateDetails(@RequestBody String custDetails) {
		   try {
		   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		   JSONObject jsonRequestData = new JSONObject(custDetails);
		   String custId = jsonRequestData.getString("Custmor_Id");
		   String pass=jsonRequestData.getString("Password");
		   int cutid=Integer.parseInt(custId);
		   Optional<Customer> cus= custservice.findById(cutid);
		   Booking bookres= new Booking();
		   if(!cus.isEmpty() && passwordEncoder.matches(pass, cus.get().getPassword())) {
			   Optional<Booking> book= hotelservice.findById(cutid);
			   bookres=book.get();
			   return new ResponseEntity<Booking>(bookres, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<String>("Invalid Login", HttpStatus.BAD_REQUEST);
		   }
		   }catch(Exception ex) {
			   return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
	   }
}
