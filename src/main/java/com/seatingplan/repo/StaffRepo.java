package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff,Long> {

}
