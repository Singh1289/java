package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer>{
	
	@Query("select count(id) from Employee")
	public int getCount();

}
