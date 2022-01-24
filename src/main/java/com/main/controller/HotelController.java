package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.CustomerDao;
import com.main.dao.RoomDao;
import com.main.entity.Booking;
import com.main.entity.Customer;
import com.main.entity.Room;
import com.main.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	HotelService hotelservice;
	@Autowired
	RoomDao roomdao;
	@Autowired
	CustomerDao custdao;

	@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
	public ResponseEntity getDetails() {
		try {
			List<Booking> book = hotelservice.getAllBookings();
			if (book.size() == 0)
				return new ResponseEntity<String>("No Records Found", HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<List<Booking>>(book, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getDetailsById/{Id}", method = RequestMethod.GET)
	public ResponseEntity getDetailsById(@PathVariable("Id") int id) {
		try {
			Booking book = hotelservice.getBookingsById(id);
			if (book == null) {
				return new ResponseEntity<String>("No Records Found", HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Booking>(book, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateDetails", method = RequestMethod.PUT)
	public ResponseEntity updateDetails(@RequestBody Booking book) {
		try {
			Optional<Customer> cus = custdao.findById(book.getCustomer_Id());
			Optional<Room> room = roomdao.findById(book.getRoom_Id());
			if (cus.isEmpty() && room.isEmpty())
				return new ResponseEntity<String>("Customer/Room is not Available", HttpStatus.BAD_REQUEST);
			else {
				hotelservice.saveOrUpdate(book, book.getBooking_Id());
				return new ResponseEntity<String>("Booking Updated Successful", HttpStatus.OK);
			}
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deleteDetails/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteDetails(@PathVariable("Id") int id) {
		try {
			hotelservice.delete(id);
			return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/createDetails", method = RequestMethod.POST)
	public ResponseEntity createDetails(@RequestBody Booking book) {
		try {
			Optional<Customer> cus = custdao.findById(book.getCustomer_Id());
			Optional<Room> room = roomdao.findById(book.getRoom_Id());
			Optional<Booking> bookId = hotelservice.findById(book.getCustomer_Id());
			//if(bookId.isEmpty()) {
			if (!cus.isEmpty() && !room.isEmpty() && !room.get().getStatus().equals("F")) {
				hotelservice.save(book);
				return new ResponseEntity<String>("Booking Details Inserted Successful", HttpStatus.CREATED);
			} else
				return new ResponseEntity<String>("Customer/Room is not Available", HttpStatus.BAD_REQUEST);
//			}else {
//				//hotelservice.saveOrUpdate(book,book.getBooking_Id());
//				return new ResponseEntity<String>("Customer Booking already exist", HttpStatus.CREATED);
//			}
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
