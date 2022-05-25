package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

}
