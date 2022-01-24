package com.main.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Booking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Booking_Id; 
//	@OneToOne(fetch = FetchType.LAZY, targetEntity=Room.class)
//	@JoinColumn(name ="Room_Id",insertable = false, updatable = false)
//	private Room room;  
	
//	@OneToOne(fetch = FetchType.LAZY,targetEntity=Customer.class,cascade = CascadeType.ALL)
//	@JoinColumn( name="Customer_Id", insertable = false, updatable = false)
//	private Customer customer;  
	@Column
	public int Room_Id;
	@Column
	public int Customer_Id;
	@Column  
	private Date Checkin_Date;
	@Column  
	private Date Checkout_Date;
	@Column  
	private String Status;
	@Column  
	private int Number_Of_People;
	
	
	public int getBooking_Id() {
		return Booking_Id;
	}
	public void setBooking_Id(int booking_Id) {
		Booking_Id = booking_Id;
	}
	
//	public Room getRoom() {
//		return room;
//	}
//	public void setRoom(Room room) {
//		this.room = room;
//	}
	public Date getCheckin_Date() {
		return Checkin_Date;
	}
	public void setCheckin_Date(Date checkin_Date) {
		Checkin_Date = checkin_Date;
	}
	public Date getCheckout_Date() {
		return Checkout_Date;
	}
	public void setCheckout_Date(Date checkout_Date) {
		Checkout_Date = checkout_Date;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getNumber_Of_People() {
		return Number_Of_People;
	}
	public void setNumber_Of_People(int number_Of_People) {
		Number_Of_People = number_Of_People;
	}
	
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public int getRoom_Id() {
		return Room_Id;
	}
	public void setRoom_Id(int room_Id) {
		Room_Id = room_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
}
