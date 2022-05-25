package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {

}
