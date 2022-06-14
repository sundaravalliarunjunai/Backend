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

import com.seatingplan.model.StudentPlan;
import com.seatingplan.repo.StudentPlanRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")
public class StudentPlanController {
	
	@Autowired
	private StudentPlanRepo StudentPlanRepository;

	@PostMapping("/StudentPlan")
	public StudentPlan saveStudentPlan(@RequestBody StudentPlan StudentPlan) {
		return StudentPlanRepository.save(StudentPlan);
	}
	@GetMapping("/StudentPlan")
	public List<StudentPlan>getAllStudentPlan() {
		return StudentPlanRepository.findAll();
	}
	
	@GetMapping("/StudentPlan/{id}")
	public ResponseEntity<StudentPlan> getStudentPlanById(@PathVariable Long id) {
		StudentPlan StudentPlan = StudentPlanRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(StudentPlan);
	}

	@PutMapping("/StudentPlan/{id}")
	public ResponseEntity<StudentPlan> updateStudentPlan(@PathVariable Long id, @RequestBody StudentPlan StudentPlanDetails) {
		StudentPlan StudentPlan = StudentPlanRepository.findById(id).orElseThrow();
		StudentPlan.setStudentId(StudentPlanDetails.studentId);
		StudentPlan.setStudentName(StudentPlanDetails.studentName);	
		StudentPlan.setSchedule(StudentPlanDetails.schedule);
		StudentPlan updatedStudentPlan = StudentPlanRepository.save(StudentPlan);
		return ResponseEntity.ok(updatedStudentPlan);
	}

	@DeleteMapping("/StudentPlan/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudentPlan(@PathVariable Long id) {
		StudentPlan StudentPlan = StudentPlanRepository.findById(id).orElseThrow();
		StudentPlanRepository.delete(StudentPlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
