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

import com.seatingplan.model.ExamDate;
import com.seatingplan.repo.ExamDateRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class ExamDateController {

	@Autowired
	private ExamDateRepo ExamDateRepository;

	@PostMapping("/ExamDate")
	public ExamDate saveExamDate(@RequestBody ExamDate ExamDate) {
		return ExamDateRepository.save(ExamDate);
	}
	@GetMapping("/ExamDate")
	public List<ExamDate>getAllExamDate() {
		return ExamDateRepository.findAll();
	}
	
	@GetMapping("/ExamDate/{id}")
	public ResponseEntity<ExamDate> getExamDateById(@PathVariable Long id) {
		ExamDate ExamDate = ExamDateRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(ExamDate);
	}

	@PutMapping("/ExamDate/{id}")
	public ResponseEntity<ExamDate> updateExamDate(@PathVariable Long id, @RequestBody ExamDate ExamDateDetails) {
		ExamDate ExamDate = ExamDateRepository.findById(id).orElseThrow();
		ExamDate.setDate(ExamDateDetails.date);	
		ExamDate.setExamNoonType(ExamDateDetails.examNoonType);
		ExamDate.setForeNoonStartingTime(ExamDateDetails.foreNoonStartingTime);
		ExamDate.setForeNoonEndingTime(ExamDateDetails.foreNoonEndingTime);
		ExamDate.setAfterNoonStartingTime(ExamDateDetails.afterNoonStartingTime);
		ExamDate.setAfterNoonEndingTime(ExamDateDetails.afterNoonEndingTime);
		ExamDate updatedExamDate = ExamDateRepository.save(ExamDate);
		return ResponseEntity.ok(updatedExamDate);
	}

	@DeleteMapping("/ExamDate/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteExamDate(@PathVariable Long id) {
		ExamDate ExamDate = ExamDateRepository.findById(id).orElseThrow();
		ExamDateRepository.delete(ExamDate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
