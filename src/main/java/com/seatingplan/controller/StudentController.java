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

import com.seatingplan.model.Student;
import com.seatingplan.repo.StudentRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class StudentController {
	
	@Autowired
	private StudentRepo StudentRepository;

	@PostMapping("/Student")
	public Student saveStudent(@RequestBody Student Student) {
		return StudentRepository.save(Student);
	}
	@GetMapping("/Student")
	public List<Student>getAllStudent() {
		return StudentRepository.findAll();
	}
	
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student Student = StudentRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(Student);
	}

	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student StudentDetails) {
		Student Student = StudentRepository.findById(id).orElseThrow();
		Student.setStudentName(StudentDetails.studentName);	
		Student.setDob(StudentDetails.dob);
		Student.setRollNo(StudentDetails.rollNo);
		Student.setDepartmentId(StudentDetails.departmentId);
		Student.setSemester(StudentDetails.semester);
		Student.setCourseType(StudentDetails.courseType);
		Student updatedStudent = StudentRepository.save(Student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
		Student Student = StudentRepository.findById(id).orElseThrow();
		StudentRepository.delete(Student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
