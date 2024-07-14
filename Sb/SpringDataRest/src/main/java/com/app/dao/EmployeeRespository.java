package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.app.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
