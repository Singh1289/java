package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeDao;
import com.app.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDao.save(theEmployee);
		
	}

}
