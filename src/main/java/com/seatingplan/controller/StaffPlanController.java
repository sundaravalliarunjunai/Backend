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

import com.seatingplan.model.StaffPlan;
import com.seatingplan.repo.StaffPlanRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class StaffPlanController {

	@Autowired
	private StaffPlanRepo StaffPlanRepository;

	@PostMapping("/StaffPlan")
	public StaffPlan saveStaffPlan(@RequestBody StaffPlan StaffPlan) {
		return StaffPlanRepository.save(StaffPlan);
	}
	@GetMapping("/StaffPlan")
	public List<StaffPlan>getAllStaffPlan() {
		return StaffPlanRepository.findAll();
	}
	
	@GetMapping("/StaffPlan/{id}")
	public ResponseEntity<StaffPlan> getStaffPlanById(@PathVariable Long id) {
		StaffPlan StaffPlan = StaffPlanRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(StaffPlan);
	}

	@PutMapping("/StaffPlan/{id}")
	public ResponseEntity<StaffPlan> updateStaffPlan(@PathVariable Long id, @RequestBody StaffPlan StaffPlanDetails) {
		StaffPlan StaffPlan = StaffPlanRepository.findById(id).orElseThrow();		
		StaffPlan.setStaffName(StaffPlanDetails.staffName);			
		StaffPlan.setSchedule(StaffPlanDetails.schedule);
		StaffPlan updatedStaffPlan = StaffPlanRepository.save(StaffPlan);
		return ResponseEntity.ok(updatedStaffPlan);
	}

	@DeleteMapping("/StaffPlan/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStaffPlan(@PathVariable Long id) {
		StaffPlan StaffPlan = StaffPlanRepository.findById(id).orElseThrow();
		StaffPlanRepository.delete(StaffPlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
