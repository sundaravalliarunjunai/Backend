package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.StudentPlan;

@Repository
public interface StudentPlanRepo extends JpaRepository<StudentPlan,Long>{

}
