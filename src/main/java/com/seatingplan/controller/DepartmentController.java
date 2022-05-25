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

import com.seatingplan.model.Department;
import com.seatingplan.repo.DepartmentRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepo DepartmentRepository;

	@PostMapping("/Department")
	public Department saveDepartment(@RequestBody Department Department) {
		return DepartmentRepository.save(Department);
	}
	@GetMapping("/Department")
	public List<Department>getAllDepartment() {
		return DepartmentRepository.findAll();
	}
	
	@GetMapping("/Department/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
		Department Department = DepartmentRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(Department);
	}

	@PutMapping("/Department/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department DepartmentDetails) {
		Department Department = DepartmentRepository.findById(id).orElseThrow();
		Department.setDepartmentName(DepartmentDetails.departmentName);	
		Department updatedDepartment = DepartmentRepository.save(Department);
		return ResponseEntity.ok(updatedDepartment);
	}

	@DeleteMapping("/Department/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable Long id) {
		Department Department = DepartmentRepository.findById(id).orElseThrow();
		DepartmentRepository.delete(Department);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
