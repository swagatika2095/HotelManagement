package com.main.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2912095093255256188L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Customer_Id; 	
	@Column  
	private String Customer_Name;
	@Column  
	private int Age;
	@Column
	private String Gender;
	@Column  
	private String Address;
	@Column  
	private String Idproof;
	@Column  
	private String Status;
	@Column 
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getIdproof() {
		return Idproof;
	}
	public void setIdproof(String idproof) {
		Idproof = idproof;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	

}
