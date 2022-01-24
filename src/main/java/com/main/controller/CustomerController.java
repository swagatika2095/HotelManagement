package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.main.entity.Customer;
import com.main.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService custservice;

	@RequestMapping(value = "/getAllCustomerDetails", method = RequestMethod.GET)
	public ResponseEntity getAllCustomerDetails() {
		try {
			List<Customer> cust = custservice.getAllCustomer();
			if (cust.size() == 0)
				return new ResponseEntity<String>("No Records Found", HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<List<Customer>>(cust, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getCustomerDetailsById/{Id}", method = RequestMethod.GET)
	public ResponseEntity getCustomerDetailsById(@PathVariable("Id") int id) {
		try {
			Customer cust = custservice.getCustomerById(id);
			if (cust == null) {
				return new ResponseEntity<String>("No Records Found", HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
			}
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateCustomerDetails", method = RequestMethod.PUT)
	public ResponseEntity updateCustomerDetails(@RequestBody Customer cust) {
		try {
			custservice.saveOrUpdate(cust, cust.getCustomer_Id());
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deleteCustomerDetails/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomerDetails(@PathVariable("Id") int id) {
		try {
			custservice.delete(id);
			return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/createCustomerDetails", method = RequestMethod.POST)
	public ResponseEntity createDetails(@RequestBody Customer cust) {
		try {
			custservice.save(cust);
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
