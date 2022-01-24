package com.main.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.entity.Room;

public interface RoomDao extends JpaRepository<Room, Integer> {
	@Modifying
	@Query("update Room r set r.Status = 'F' where r.Room_Id =:Room_Id")
	void roomStatus(@Param("Room_Id") int Room_Id);

}
