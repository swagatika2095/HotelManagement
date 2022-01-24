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
import com.main.entity.Room;
import com.main.service.RoomService;

@RestController
public class RoomController {
	@Autowired
	RoomService roomservice;

	@RequestMapping(value = "/getAllRoomDetails", method = RequestMethod.GET)
	public ResponseEntity getAllRoomDetails() {
		try {
			List<Room> room = roomservice.getAllRoom();
			if (room.size() == 0)
				return new ResponseEntity<String>("No Records Found", HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<List<Room>>(room, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getRoomDetailsById/{Id}", method = RequestMethod.GET)
	public ResponseEntity getRoomDetailsById(@PathVariable("Id") int id) {
		try {
			Room room = roomservice.getRoomById(id);
			if (room == null) {
				return new ResponseEntity<String>("No Records Found", HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Room>(room, HttpStatus.CREATED);
			}
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateRoomDetails", method = RequestMethod.PUT)
	public ResponseEntity updateRoomDetails(@RequestBody Room room) {
		try {
			roomservice.saveOrUpdate(room, room.getRoom_Id());
			return new ResponseEntity<Room>(room, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deleteRoomDetails/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteRoomDetails(@PathVariable("Id") int id) {
		try {
			roomservice.delete(id);
			return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/createRoomDetails", method = RequestMethod.POST)
	public ResponseEntity createDetails(@RequestBody Room room) {
		try {
			roomservice.save(room);
			return new ResponseEntity<Room>(room, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
