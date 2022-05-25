package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.ExamDate;

@Repository
public interface ExamDateRepo extends JpaRepository<ExamDate,Long> {

}
