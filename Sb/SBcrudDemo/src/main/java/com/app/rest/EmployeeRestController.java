package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//expose "/employees" and return list of employess
		@GetMapping("/employees")
		public List<Employee> findAll()
		{
			return employeeService.findAll();
		}
		
		@GetMapping("/employees/{employeeId}")
		public Employee getEmployee(@PathVariable int employeeId)
		{
			Employee theEmployee = employeeService.findById(employeeId);
			if(theEmployee == null)
			{
				throw new RuntimeException("Employee Not found - "+employeeId);
			}
			return theEmployee;
		}
		
		
		//'/employees' - add new employee
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee theEmployee)
		{
			theEmployee.setId(0);
			employeeService.save(theEmployee);
			return theEmployee;
		}
		
		
		//'/employees' - update an employee
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee)
		{
			employeeService.save(theEmployee);
			return theEmployee;
		}
		
		@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId)
		{
			Employee tempEmployee = employeeService.findById(employeeId);
			System.out.println("Employee = "+tempEmployee);
			if(tempEmployee == null)
			{
				//throw new RuntimeException("Employee id not found: "+employeeId);
				return "Employee id not found: "+employeeId;
			}
			
			employeeService.deleteById(employeeId);
			
			return "Deleted Employee ID - "+employeeId;
		}

}
