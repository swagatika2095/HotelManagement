package com.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.RoomDao;
import com.main.entity.Room;

@Service
public class RoomService {
	@Autowired
	RoomDao roomdao;
	
	public List<Room> getAllRoom(){
		List<Room> room = new ArrayList<Room>();  
		roomdao.findAll().forEach(room1 -> room.add(room1)); 
		return room;  
	}
	public  Room getRoomById(int id)   
	{  
	return roomdao.findById(id).get();  
	} 
	public  void saveOrUpdate(Room room,int roomid)   
	{  
		roomdao.save(room);  
	}
	public  void save(Room room)   
	{  
		roomdao.save(room);  
	} 
	public  void delete(int id)   
	{  
		roomdao.deleteById(id);  
	}
}
