package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.CustomerDao;
import com.main.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao custdao;
	
	public List<Customer> getAllCustomer(){
		List<Customer> customer = new ArrayList<Customer>();  
		custdao.findAll().forEach(customer1 -> customer.add(customer1)); 
		return customer;  
	}
	public  Customer getCustomerById(int id)   
	{  
	return custdao.findById(id).get();  
	} 
	public  void saveOrUpdate(Customer customer,int custid)   
	{  
		custdao.save(customer);  
	}
	public  void save(Customer customer)   
	{  
		custdao.save(customer);  
	} 
	public  void delete(int id)   
	{  
		custdao.deleteById(id);  
	}
	public Optional<Customer> findById(int customer_Id) {
		// TODO Auto-generated method stub
		return custdao.findById(customer_Id);
	}

}
