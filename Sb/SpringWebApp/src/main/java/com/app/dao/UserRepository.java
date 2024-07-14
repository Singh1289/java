package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("FROM User u WHERE u.email = :email and u.password = :password")
	public User validateUser( String email, String password);

}
