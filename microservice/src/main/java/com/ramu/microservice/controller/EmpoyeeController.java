package com.ramu.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramu.microservice.entity.Employee;
import com.ramu.microservice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmpoyeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return ResponseEntity.ok(service.saveEmployee(emp));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.getEmployeeById(id));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
		service.deleteEmployee(id);
		return ResponseEntity.ok("Employee '" + id + "' deleted ");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateeEmployee(@PathVariable("id") Integer id, @RequestBody Employee emp) {
		Employee employee = service.getEmployeeById(id);
		employee.setEmpDept(emp.getEmpDept());
		employee.setEmpName(emp.getEmpName());
		employee.setEmpSalary(emp.getEmpSalary());
		return ResponseEntity.ok(service.saveEmployee(emp));
	}
}
