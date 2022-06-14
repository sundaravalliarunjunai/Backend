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

import com.seatingplan.model.SubjectPlan;
import com.seatingplan.repo.SubjectPlanRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")
public class SubjectPlanController {
	
	@Autowired
	private SubjectPlanRepo SubjectPlanRepository;

	@PostMapping("/SubjectPlan")
	public SubjectPlan saveSubjectPlan(@RequestBody SubjectPlan SubjectPlan) {
		return SubjectPlanRepository.save(SubjectPlan);
	}
	@GetMapping("/SubjectPlan")
	public List<SubjectPlan>getAllSubjectPlan() {
		return SubjectPlanRepository.findAll();
	}
	
	@GetMapping("/SubjectPlan/{id}")
	public ResponseEntity<SubjectPlan> getSubjectPlanById(@PathVariable Long id) {
		SubjectPlan SubjectPlan = SubjectPlanRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(SubjectPlan);
	}

	@PutMapping("/SubjectPlan/{id}")
	public ResponseEntity<SubjectPlan> updateSubjectPlan(@PathVariable Long id, @RequestBody SubjectPlan SubjectPlanDetails) {
		SubjectPlan SubjectPlan = SubjectPlanRepository.findById(id).orElseThrow();
		SubjectPlan.setSubjectId(SubjectPlanDetails.subjectId);
		SubjectPlan.setSubjectName(SubjectPlanDetails.subjectName);	
		SubjectPlan.setExamDateAndTimeId(SubjectPlanDetails.examDateAndTimeId);
		SubjectPlan.setSummary(SubjectPlanDetails.summary);
		SubjectPlan updatedSubjectPlan = SubjectPlanRepository.save(SubjectPlan);
		return ResponseEntity.ok(updatedSubjectPlan);
	}

	@DeleteMapping("/SubjectPlan/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSubjectPlan(@PathVariable Long id) {
		SubjectPlan SubjectPlan = SubjectPlanRepository.findById(id).orElseThrow();
		SubjectPlanRepository.delete(SubjectPlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
