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

import com.seatingplan.model.User;
import com.seatingplan.repo.UserRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")

public class UserController {
	
	@Autowired
	private UserRepo UserRepository;

	@PostMapping("/User")
	public User saveUser(@RequestBody User User) {
		return UserRepository.save(User);
	}
	@GetMapping("/User")
	public List<User>getAllUser() {
		return UserRepository.findAll();
	}
	
	@GetMapping("/User/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User User = UserRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(User);
	}
	
	@GetMapping("/User/{userName}/{password}")
	public ResponseEntity<User> loginauth(@PathVariable("userName") String userName,@PathVariable("password") String password){
		User user=UserRepository.findbyEmail(userName,password);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/User/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User UserDetails) {
		User User = UserRepository.findById(id).orElseThrow();
		User.setUserType(UserDetails.userType);	
		User.setUserName(UserDetails.userName);
		User.setPassword(UserDetails.password);
		User.setStaffId(UserDetails.staffId);
		User.setStudentId(UserDetails.studentId);
		User updatedUser = UserRepository.save(User);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/User/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
		User User = UserRepository.findById(id).orElseThrow();
		UserRepository.delete(User);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
