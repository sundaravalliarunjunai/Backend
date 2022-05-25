package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {

}
