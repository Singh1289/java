package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	//@Autowired
	/*
	 * public EmployeeDAOJpaImpl(EntityManager theEntityManager) { entityManager =
	 * theEntityManager; }
	 */


	@Override
	public List<Employee> findAll() {
		//create a query
		Query theQuery = entityManager.createQuery("from Employee");
		//get the result List
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get Employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		//if id==0  then save/insert else update
		//update with id from db....so we can get generated id for save and insert
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		//entityManager.remove
		Query theQuery = entityManager.createQuery("delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}



}
