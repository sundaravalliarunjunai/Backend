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

import com.seatingplan.model.Buildings;
import com.seatingplan.repo.BuildingsRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")
public class BuildingsController {

	@Autowired
	private BuildingsRepo BuildingRepository;

	@PostMapping("/Buildings")
	public Buildings saveBuildings(@RequestBody Buildings Buildings) {
		return BuildingRepository.save(Buildings);
	}
	@GetMapping("/Buildings")
	public List<Buildings>getAllBuildingss() {
		return BuildingRepository.findAll();
	}

	@GetMapping("/Buildings/{id}")
	public ResponseEntity<Buildings> getBuildingsById(@PathVariable Long id) {
		Buildings Buildings = BuildingRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(Buildings);
	}
	
	@GetMapping("/Buildings/{buildingId}/{buildingName}")
	public ResponseEntity<Buildings> getBuilding(@PathVariable("buildingId") long buildingId, @PathVariable("buildingName") String buildingName){
		Buildings Buildings =BuildingRepository.findbyBuilding(buildingId, buildingName);
		return ResponseEntity.ok(Buildings);
	}
	

	@PutMapping("/Buildings/{id}")
	public ResponseEntity<Buildings> updateBuildings(@PathVariable Long id, @RequestBody Buildings BuildingsDetails) {
		Buildings Buildings = BuildingRepository.findById(id).orElseThrow();
		Buildings.setBuildingName(BuildingsDetails.buildingName);	
		Buildings.setStatus(BuildingsDetails.status);
		Buildings updatedBuildings = BuildingRepository.save(Buildings);
		return ResponseEntity.ok(updatedBuildings);
	}

	@DeleteMapping("/Buildings/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuildings(@PathVariable Long id) {
		Buildings Buildings = BuildingRepository.findById(id).orElseThrow();
		BuildingRepository.delete(Buildings);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
