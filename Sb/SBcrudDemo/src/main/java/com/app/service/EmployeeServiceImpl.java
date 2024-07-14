package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDAO;
import com.app.dao.EmployeeRespository;
import com.app.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	/*
	 * @Autowired private EmployeeDAO employeeDAO;
	 * 
	 */
	
	@Autowired
	private EmployeeRespository employeeRespository;
	
	
	/*
 * public EmployeeServiceImpl(@Qualifier("EmployeeDAOJpaImpl") 
 * EmployeeDAO theEmployeeDAO)
	 * { 
	 * employeeDAO = theEmployeeDAO;
	 *  }
	 */

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}
	@Override
	@Transactional
	public Employee findById(int theId) {
		
		Optional<Employee> o = employeeRespository.findById(theId);
		if(o.isEmpty())
		{
			return null;
		}
		else
		{
		//System.out.println("o = "+o);
		Employee e = o.get();
		return e;
		}
	}
	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRespository.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRespository.deleteById(theId);
	}
}
