package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee aaddEmplyee(@RequestBody Employee theEmployee) {
		
		//TODO: process POST request
		//also just in case they pass an id inn JSON... set id to 0
		//this is to force a save of new item... instead of update
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	

}
