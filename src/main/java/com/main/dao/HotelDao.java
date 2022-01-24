package com.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Booking;
@Repository
public interface HotelDao extends CrudRepository<Booking,Integer>{

}
