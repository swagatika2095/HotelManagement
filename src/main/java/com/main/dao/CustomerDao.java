package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
