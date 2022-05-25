package com.seatingplan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatingplan.model.Room;
import com.seatingplan.repo.RoomRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")
public class RoomController {
	
	@Autowired
	private RoomRepo RoomRepository;

	@PostMapping("/Room")
	public Room saveRoom(@RequestBody Room Room) {
		return RoomRepository.save(Room);
	}
	@GetMapping("/Room")
	public List<Room>getAllRoom() {
		return RoomRepository.findAll();
	}
	
	@GetMapping("/Room/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
		Room Room = RoomRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(Room);
	}

	@PutMapping("/Room/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room RoomDetails) {
		Room Room = RoomRepository.findById(id).orElseThrow();
		Room.setBuildingId(RoomDetails.buildingId);
		Room.setRoomName(RoomDetails.roomName);	
		Room.setSeatCapacity(RoomDetails.seatCapacity);
		Room updatedRoom = RoomRepository.save(Room);
		return ResponseEntity.ok(updatedRoom);
	}

	@DeleteMapping("/Room/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoom(@PathVariable Long id) {
		Room Room = RoomRepository.findById(id).orElseThrow();
		RoomRepository.delete(Room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
