package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee dbEmployee= entityManager.merge(theEmployee);
		
		theEmployee.setId(dbEmployee.getId());
		
	}

}
