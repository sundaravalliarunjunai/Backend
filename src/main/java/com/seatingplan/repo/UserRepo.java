package com.seatingplan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seatingplan.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	
	@Query(value= "Select * from user where user_name= ?1 and password = ?2",nativeQuery=true)
	public User findbyEmail(String userName, String password);

}
