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

import com.seatingplan.model.RoomPlan;
import com.seatingplan.repo.RoomPlanRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class RoomPlanController {

	@Autowired
	private RoomPlanRepo RoomPlanRepository;

	@PostMapping("/RoomPlan")
	public RoomPlan saveRoomPlan(@RequestBody RoomPlan RoomPlan) {
		return RoomPlanRepository.save(RoomPlan);
	}
	@GetMapping("/RoomPlan")
	public List<RoomPlan>getAllRoomPlan() {
		return RoomPlanRepository.findAll();
	}
	
	@GetMapping("/RoomPlan/{id}")
	public ResponseEntity<RoomPlan> getRoomPlanById(@PathVariable Long id) {
		RoomPlan RoomPlan = RoomPlanRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(RoomPlan);
	}

	@PutMapping("/RoomPlan/{id}")
	public ResponseEntity<RoomPlan> updateRoomPlan(@PathVariable Long id, @RequestBody RoomPlan RoomPlanDetails) {
		RoomPlan RoomPlan = RoomPlanRepository.findById(id).orElseThrow();
		RoomPlan.setRoomId(RoomPlanDetails.roomId);
		RoomPlan.setRoomName(RoomPlanDetails.roomName);	
		RoomPlan.setSchedule(RoomPlanDetails.schedule);
		RoomPlan updatedRoomPlan = RoomPlanRepository.save(RoomPlan);
		return ResponseEntity.ok(updatedRoomPlan);
	}

	@DeleteMapping("/RoomPlan/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoomPlan(@PathVariable Long id) {
		RoomPlan RoomPlan = RoomPlanRepository.findById(id).orElseThrow();
		RoomPlanRepository.delete(RoomPlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
