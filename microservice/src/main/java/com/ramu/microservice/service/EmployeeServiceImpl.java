package com.ramu.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramu.microservice.entity.Employee;
import com.ramu.microservice.exception.EmployeeNotFoundexception;
import com.ramu.microservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeNotFoundexception {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundexception("Employee not Exist"));
	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeNotFoundexception {
		Employee emp = getEmployeeById(id);
		repository.delete(emp);
	}

}
