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

import com.seatingplan.model.ExamDateAndTime;
import com.seatingplan.repo.ExamDateAndTimeRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class ExamDateAndTimeController {

	@Autowired
	private ExamDateAndTimeRepo ExamDateAndTimeRepository;

	@PostMapping("/ExamDateAndTime")
	public ExamDateAndTime saveExamDateAndTime(@RequestBody ExamDateAndTime ExamDateAndTime) {
		return ExamDateAndTimeRepository.save(ExamDateAndTime);
	}
	@GetMapping("/ExamDateAndTime")
	public List<ExamDateAndTime>getAllExamDateAndTime() {
		return ExamDateAndTimeRepository.findAll();
	}
	
	@GetMapping("/ExamDateAndTime/{id}")
	public ResponseEntity<ExamDateAndTime> getExamDateAndTimeById(@PathVariable Long id) {
		ExamDateAndTime ExamDateAndTime = ExamDateAndTimeRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(ExamDateAndTime);
	}

	@PutMapping("/ExamDateAndTime/{id}")
	public ResponseEntity<ExamDateAndTime> updateExamDateAndTime(@PathVariable Long id, @RequestBody ExamDateAndTime ExamDateAndTimeDetails) {
		ExamDateAndTime ExamDateAndTime = ExamDateAndTimeRepository.findById(id).orElseThrow();
		ExamDateAndTime.setExamDateId(ExamDateAndTimeDetails.examDateId);	
		ExamDateAndTime.setExamNoonType(ExamDateAndTimeDetails.examNoonType);
		ExamDateAndTime.setSubjectId(ExamDateAndTimeDetails.subjectId);
		ExamDateAndTime updatedExamDateAndTime = ExamDateAndTimeRepository.save(ExamDateAndTime);
		return ResponseEntity.ok(updatedExamDateAndTime);
	}

	@DeleteMapping("/ExamDateAndTime/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteExamDateAndTime(@PathVariable Long id) {
		ExamDateAndTime ExamDateAndTime = ExamDateAndTimeRepository.findById(id).orElseThrow();
		ExamDateAndTimeRepository.delete(ExamDateAndTime);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
//	@DeleteMapping("/ExamDateAndTime/{examDateID}")
//	public ResponseEntity<Map<String, Boolean>> deleteExamDateAndTime1(@PathVariable Long id) {
//		ExamDateAndTime ExamDateAndTime = ExamDateAndTimeRepository.findById(id).orElseThrow();
//		ExamDateAndTimeRepository.delete(ExamDateAndTime);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
}
