package com.ramu.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ramu.microservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where email= :email and password = :password")
	User validateUser(@Param("email") String userName, @Param("password") String password);

	@Query("from User where email= :email")
	User checkUserExistedOrNot(@Param("email") String email);

}
