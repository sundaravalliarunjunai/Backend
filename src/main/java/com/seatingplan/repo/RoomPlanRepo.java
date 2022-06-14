package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.RoomPlan;

@Repository
public interface RoomPlanRepo extends JpaRepository<RoomPlan,Long>{

}
