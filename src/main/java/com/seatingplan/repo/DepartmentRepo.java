package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

}
