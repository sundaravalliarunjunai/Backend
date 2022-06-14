package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.SubjectPlan;

@Repository
public interface SubjectPlanRepo extends JpaRepository<SubjectPlan,Long> {

}
