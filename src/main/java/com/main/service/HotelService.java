package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.HotelDao;
import com.main.dao.RoomDao;
import com.main.entity.Booking;


@Service
public class HotelService {
	
	
@Autowired
HotelDao hoteldao;
@Autowired
RoomDao roomdao;

	
public List<Booking> getAllBookings(){
	List<Booking> bookings = new ArrayList<Booking>();  
		hoteldao.findAll().forEach(bookings1 -> bookings.add(bookings1)); 
	return bookings;  
}
public  Booking getBookingsById(int id)   
{  
return hoteldao.findById(id).get();  
} 
public  void saveOrUpdate(Booking bookings,int bookingid)   
{  
	hoteldao.save(bookings);  
}
@Transactional
public  void save(Booking bookings)   
{  
	hoteldao.save(bookings);
	roomdao.roomStatus(bookings.getRoom_Id());
} 
public  void delete(int id)   
{  
	hoteldao.deleteById(id);  
}
public Optional<Booking> findById(int room_Id) {
	// TODO Auto-generated method stub
	return hoteldao.findById(room_Id);
}  

}
