package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.StaffPlan;

@Repository
public interface StaffPlanRepo extends JpaRepository<StaffPlan,Long>{

}
