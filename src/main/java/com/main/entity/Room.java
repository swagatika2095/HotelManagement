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
public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936659123825274282L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Room_Id; 	
	@Column  
	private String Room_Type;
	@Column  
	private int Cost;
	@Column  
	private String Description;
	@Column  
	private String Status;
	public int getRoom_Id() {
		return Room_Id;
	}
	public void setRoom_Id(int room_Id) {
		Room_Id = room_Id;
	}
	public String getRoom_Type() {
		return Room_Type;
	}
	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
