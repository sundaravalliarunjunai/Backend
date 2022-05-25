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

import com.seatingplan.model.Staff;
import com.seatingplan.repo.StaffRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class StaffController {

	@Autowired
	private StaffRepo StaffRepository;

	@PostMapping("/Staff")
	public Staff saveStaff(@RequestBody Staff Staff) {
		return StaffRepository.save(Staff);
	}
	@GetMapping("/Staff")
	public List<Staff>getAllStaff() {
		return StaffRepository.findAll();
	}
	
	@GetMapping("/Staff/{id}")
	public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
		Staff Staff = StaffRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(Staff);
	}

	@PutMapping("/Staff/{id}")
	public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff StaffDetails) {
		Staff Staff = StaffRepository.findById(id).orElseThrow();
		Staff.setStaffName(StaffDetails.staffName);	
		Staff.setDob(StaffDetails.dob);
		Staff.setDepartmentId(StaffDetails.departmentId);
		Staff updatedStaff = StaffRepository.save(Staff);
		return ResponseEntity.ok(updatedStaff);
	}

	@DeleteMapping("/Staff/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStaff(@PathVariable Long id) {
		Staff Staff = StaffRepository.findById(id).orElseThrow();
		StaffRepository.delete(Staff);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
