package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seatingplan.model.Buildings;

@Repository
public interface BuildingsRepo extends JpaRepository<Buildings,Long>{
	
	@Query(value= "Select * from buildings",nativeQuery=true)
	public Buildings findbyBuilding(long buildingId, String buildingName);
	
	@Transactional
	@Modifying
	@Query(value="Update buildings set buildingName= :buildingName where buildingId= :buildingId", nativeQuery=true)
	public Buildings findbyUpdataBuilding(long buildingId, String buildingName);

}
