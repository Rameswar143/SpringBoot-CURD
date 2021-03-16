package com.ramu.microservice.service;

import java.util.List;

import com.ramu.microservice.entity.Employee;
import com.ramu.microservice.exception.EmployeeNotFoundexception;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer id) throws EmployeeNotFoundexception;

	void deleteEmployee(Integer id) throws EmployeeNotFoundexception;

}
