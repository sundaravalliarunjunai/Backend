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

import com.seatingplan.model.Subject;
import com.seatingplan.repo.SubjectRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class SubjectController {
	
	@Autowired
	private SubjectRepo SubjectRepository;

	@PostMapping("/Subject")
	public Subject saveSubject(@RequestBody Subject Subject) {
		return SubjectRepository.save(Subject);
	}
	@GetMapping("/Subject")
	public List<Subject>getAllSubject() {
		return SubjectRepository.findAll();
	}
	
	@GetMapping("/Subject/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
		Subject Subject = SubjectRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(Subject);
	}

	@PutMapping("/Subject/{id}")
	public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject SubjectDetails) {
		Subject Subject = SubjectRepository.findById(id).orElseThrow();
		Subject.setCourseCode(SubjectDetails.courseCode);
		Subject.setSubjectName(SubjectDetails.subjectName);	
		Subject.setSemester(SubjectDetails.semester);
		Subject.setDepartment(SubjectDetails.department);
		Subject.setCourseType(SubjectDetails.courseType);
		Subject updatedSubject = SubjectRepository.save(Subject);
		return ResponseEntity.ok(updatedSubject);
	}

	@DeleteMapping("/Subject/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSubject(@PathVariable Long id) {
		Subject Subject = SubjectRepository.findById(id).orElseThrow();
		SubjectRepository.delete(Subject);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
